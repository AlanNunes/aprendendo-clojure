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
  ;(pprint (deve-assinar-pre-autorizacao? particular, :raio-x, 500))
  ;(pprint (deve-assinar-pre-autorizacao? particular, :raio-x, 10))
  ;(pprint (deve-assinar-pre-autorizacao? plano, :raio-x, 10))
  ;(pprint (deve-assinar-pre-autorizacao? plano, :coleta-de-sangue, 10))
  )

(defprotocol Ave
  (voa [this]))

(defrecord Coruja [nome]
  Ave
  (voa [this]
    (println (:nome this) "Voando...")))

(let [coruja (->Coruja "Owl")]
  ;(voa coruja)
  )

(defprotocol Dateable
  (to-ms [this]))

(extend-type java.lang.Number
  Dateable
  (to-ms [this] this))

;(println (to-ms 777))

(extend-type java.util.Date
  Dateable
  (to-ms [this] (.getTime this)))

;(println (to-ms (java.util.Date.)))

(extend-type java.util.Calendar
  Dateable
  (to-ms [this] (to-ms (.getTime this))))

;(println (to-ms (java.util.GregorianCalendar.)))





(defprotocol MeuRandomModificado
  (nextIntComString [this]))

(extend-type java.util.Random
  MeuRandomModificado
  (nextIntComString [this]
    (let [valor-aleatorio (.nextInt (java.util.Random.))]
      (str valor-aleatorio "-clojure"))))

;(println "Extendendo uma classe Java e usando interopabilidade de Java e Clojure")
;(println (nextIntComString (java.util.Random.)))














; Definição da função
(defn cospe-mensagem
  [de ate msg]
  (when (<= de ate)
    (println (str de " " msg))
    (recur (inc de) ate msg)))

; Chamada da função
(cospe-mensagem 0 42000 "Teste")








































