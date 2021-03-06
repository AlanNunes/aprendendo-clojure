(ns hospital.aula1
  (:use [clojure pprint])
  (:require [hospital.model :as h.model]
            [hospital.logica :as h.logica]))

(defn simula-um-dia []
  ; root binding
  (def hospital (h.model/novo-hospital))
  (def hospital (h.logica/chega-em hospital :espera "111"))
  (def hospital (h.logica/chega-em hospital :espera "222"))
  (def hospital (h.logica/chega-em hospital :espera "333"))
  (pprint hospital)

  (def hospital (h.logica/chega-em hospital :laboratorio1 "444"))
  (def hospital (h.logica/chega-em hospital :laboratorio3 "555"))
  (pprint hospital)

  (def hospital (h.logica/atende hospital :laboratorio1))
  (def hospital (h.logica/atende hospital :espera))
  (pprint hospital)
  (def hospital (h.logica/chega-em hospital :espera "666"))
  (def hospital (h.logica/chega-em hospital :espera "777"))
  (def hospital (h.logica/chega-em hospital :espera "888"))
  (def hospital (h.logica/chega-em hospital :espera "999"))
  (pprint hospital)
  )

;(simula-um-dia)

(defn chega-em-malvado [pessoa]
  (def hospital (h.logica/chega-em-pausado hospital :espera pessoa))
  (println "após inserir pessoa" pessoa))

(defn simula-um-dia-em-paralelo []
  (def hospital (h.model/novo-hospital))
  (.start (Thread. (fn [] (chega-em-malvado "111"))))
  (.start (Thread. (fn [] (chega-em-malvado "222"))))
  (.start (Thread. (fn [] (chega-em-malvado "333"))))
  (.start (Thread. (fn [] (chega-em-malvado "444"))))
  (.start (Thread. (fn [] (chega-em-malvado "555"))))
  (.start (Thread. (fn [] (chega-em-malvado "666"))))
  (.start (Thread. (fn [] (Thread/sleep 4000)
                                        (pprint hospital))))
  )

(simula-um-dia-em-paralelo)