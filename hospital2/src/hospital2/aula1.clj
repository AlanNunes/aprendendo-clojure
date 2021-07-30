(ns hospital2.aula1
  (:use clojure.pprint))

(defn adiciona-paciente
  "Os pacientes são um mapa da seguinte forma { 15 {paciente 15}, 23 {paciente 23} }.
  O paciente { :id 15 ... }"
  [pacientes paciente]
  (if-let [id (:id paciente)]
    (assoc pacientes id paciente)
    (throw (ex-info "Paciente não possui id" {:paciente paciente}))))

(defn testa-uso-de-pacientes []
  (let [pacientes {}
        guilherme {:id 15 :nome "Guilherme" :nascimento "18/9/1981"}
        daniela {:id 20 :nome "Daniela" :nascimento "18/9/1982"}
        paulo {:nome "Paulo", :nascimento "18/10/1983"}]
    (pprint (adiciona-paciente pacientes guilherme))
    (pprint (adiciona-paciente pacientes daniela))
    (pprint (adiciona-paciente pacientes paulo))
    ))

;(testa-uso-de-pacientes)

(defrecord Paciente [id nome nascimento])

(println (->Paciente 15 "Alan" "29/04/2000"))
(println (Paciente. 15 "Alan" "29/04/2000"))
(println (map->Paciente {:id 15 :nome "Alan" :nascimento "29/04/2000"}))