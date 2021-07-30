(ns hospital2.aula2
  (:use clojure.pprint))

(defrecord PacienteParticular [id, nome, nascimento])
(defrecord PacientePlanoDeSaude [id, nome, nascimento, plano])

(defprotocol Cobravel
  (deve-assinar-pre-autorizacao? [paciente procedimento valor]))

(extend-type PacienteParticular
  Cobravel
  (deve-assinar-pre-autorizacao? [paciente, procedimento valor]
    (>= valor 50)))

(extend-type PacientePlanoDeSaude
  Cobravel
  (deve-assinar-pre-autorizacao? [paciente, procedimento, valor]
    (let [plano (:plano paciente)]
      (not (some #(= % procedimento) plano)))))

(let [particular (->PacienteParticular 15 "Alan" "29/04/2000")
      plano (->PacientePlanoDeSaude 15, "Karynne" "17/09/2001", [:raio-x :ultrasson])]
  (pprint (deve-assinar-pre-autorizacao? particular, :raio-x, 500))
  (pprint (deve-assinar-pre-autorizacao? particular, :raio-x, 10))
  (pprint (deve-assinar-pre-autorizacao? plano, :raio-x, 10))
  (pprint (deve-assinar-pre-autorizacao? plano, :coleta-de-sangue, 10)))

(defprotocol Ave
  (voa [this]))

(defrecord Coruja [nome]
  Ave
  (voa [this]
    (println (:nome this) "Voando...")))

(let [coruja (->Coruja "Owl")]
  (voa coruja))
