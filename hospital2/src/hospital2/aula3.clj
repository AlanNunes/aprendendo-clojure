(ns hospital2.aula3
  (:use clojure.pprint)
  (:use [hospital2.logic :as h.logic]))

(defn carrega-paciente [id]
  (println "Carregando" id)
  (Thread/sleep 1000)
  {:id id, :carregado-em (h.logic/agora)})

;(println (carrega-paciente 15))

(defn carrega-se-nao-existe
  [cache id carregadora]
  (if (contains? cache id)
    cache
    (let [paciente (carregadora id)]
      (assoc cache id paciente))))

;(pprint (carrega-se-nao-existe {} 15 carrega-paciente))
;(pprint (carrega-se-nao-existe {15 {:id 15}} 15 carrega-paciente))

(defprotocol Carregavel
  (carrega! [this id]))

(defrecord Cache
  [cache carregadora]
  Carregavel
  (carrega! [this id]
    (swap! cache carrega-se-nao-existe id carregadora)
    (get @cache id)))

(def pacientes (->Cache (atom {}), carrega-paciente))
(carrega! pacientes 15)
(carrega! pacientes 15)
(carrega! pacientes 30)