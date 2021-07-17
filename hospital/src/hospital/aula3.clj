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

(testa-atomo)