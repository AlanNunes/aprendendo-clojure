(ns hospital.aula5
  (:use [clojure pprint]
        [hospital.logica :as h.logica]
        [hospital.model :as h.model]))

(defn chega-em!
  [hospital pessoa]
  (swap! hospital h.logica/chega-em :espera pessoa))

(defn transfere!
  [hospital de para]
  (swap! hospital h.logica/transfere de para))

(defn simula-um-dia []
  (let [hospital (atom (h.model/novo-hospital))]
    (chega-em! hospital "Alan")
    (chega-em! hospital "Karynne")
    (chega-em! hospital "Tainan")
    (chega-em! hospital "Luan")
    (transfere! hospital :espera :laboratorio1)
    (transfere! hospital :espera :laboratorio2)
    (transfere! hospital :espera :laboratorio3)
    (transfere! hospital :laboratorio1 :laboratorio2)
    (pprint hospital)))

(simula-um-dia)