(ns hospital.aula3
  (:use [clojure pprint]
        [hospital.logica :as h.logica]
        [hospital.model :as h.model]))

(defn testa-atomo
  []
  (let [hospital-macarrao (atom (h.model/novo-hospital))]
    (pprint hospital-macarrao)
    (pprint (update @hospital-macarrao :espera conj "111"))
    (swap! hospital-macarrao update :espera conj "111")
    (pprint hospital-macarrao)
    ))

;(testa-atomo)

(defn chega-em-malvado! [hospital pessoa]
  (swap! hospital h.logica/chega-em-pausado :espera pessoa)
  (println "após inserir pessoa" pessoa))

(defn simula-um-dia-em-paralelo []
  (let [hospital (atom (h.model/novo-hospital))]
    (.start (Thread. (fn [] (chega-em-malvado! hospital "111"))))
    (.start (Thread. (fn [] (chega-em-malvado! hospital "222"))))
    (.start (Thread. (fn [] (chega-em-malvado! hospital "333"))))
    (.start (Thread. (fn [] (chega-em-malvado! hospital "444"))))
    (.start (Thread. (fn [] (chega-em-malvado! hospital "555"))))
    (.start (Thread. (fn [] (chega-em-malvado! hospital "666"))))
    (.start (Thread. (fn [] (Thread/sleep 8000)
                         (pprint hospital))))
    )
  )

(simula-um-dia-em-paralelo)