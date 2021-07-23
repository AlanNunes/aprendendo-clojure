(ns hospital.aula6
  (:use [clojure pprint])
  (:require [hospital.model :as h.model]))

(defn cabe-na-fila?
  [fila]
  (-> fila
      (count)
      (< 5)))

(defn chega-em [fila pessoa]
  (if (cabe-na-fila? fila)
    (conj fila pessoa)
    (throw (ex-info "Fila já está cheia!" {:tentando-adicionar pessoa})))
  )
(defn chega-em!
  [hospital pessoa]
  (let [fila (get hospital :espera)]
    (ref-set fila (chega-em @fila pessoa))))

(defn chega-em!
  "Alterando sem dereferenciar"
  [hospital pessoa]
  (let [fila (get hospital :espera)]
    (alter fila chega-em pessoa)))

(defn simula-um-dia []
  (let [hospital {:espera       (ref h.model/fila-vazia)
                  :laboratorio1 (ref h.model/fila-vazia)
                  :laboratorio2 (ref h.model/fila-vazia)
                  :laboratorio3 (ref h.model/fila-vazia)}]
    (dosync
      (chega-em! hospital "Alan")
      (chega-em! hospital "Karynne")
      (chega-em! hospital "Tainan")
      (chega-em! hospital "Luan")
      (chega-em! hospital "Pretinha")
      (chega-em! hospital "Black")
      )
    (pprint hospital)
    ))

;(simula-um-dia)

(defn async-chega-em! [hospital pessoa]
  (future
    (Thread/sleep (rand 5000))
    (dosync
      (println "Tentando o codigo sincronizado" pessoa)
      (chega-em! hospital pessoa))))

(defn simula-um-dia-async []
  (let [hospital {:espera       (ref h.model/fila-vazia)
                  :laboratorio1 (ref h.model/fila-vazia)
                  :laboratorio2 (ref h.model/fila-vazia)
                  :laboratorio3 (ref h.model/fila-vazia)}]
    (dotimes [n 6]
      (async-chega-em! hospital n))
    (future
      (dotimes [n 4]
        (Thread/sleep 2000)
        (pprint hospital)))
    ))

(simula-um-dia-async)
;(println (future 15))