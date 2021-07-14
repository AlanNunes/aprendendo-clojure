(ns loja.aula5
  (:require [loja.db :as l.db]
            [loja.logica :as l.logica]))

(defn gastou-bastante? [info-do-usuario]
  (println info-do-usuario)
  (> (:valor-total info-do-usuario) 500))

(let [pedidos (l.db/todos-os-pedidos)
      resumo (l.logica/resumo-por-usuario pedidos)]
  (println (keep gastou-bastante? resumo))
  )

(let [valores (range 10000000000000000000000000)]
  (println (take 2 valores)))

(defn filtro1 [x]
  (println "Filtro1:" x)
  (* x 2))

(defn filtro2 [x]
  (println "Filtro2:" x)
  x)

; LAZY + EAGER
(->> (range 50)
     (map filtro1)
     (map filtro2))

; LAZY
(->> (range 50)
     (mapv filtro1)
     (mapv filtro2))

; TOTALMENTE LAZY
(->> '(0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32)
     (map filtro1)
     (map filtro2))

(defn filtro [v]
  (println "Filtrando:" v)
  (when (even? v)
    v))

(println (keep filtro (range 50)))