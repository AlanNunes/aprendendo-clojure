(ns loja.aula4
  (:require [loja.db :as l.db]
            [loja.logica :as l.logica]))

(println (l.db/todos-os-pedidos))

(let [pedidos (l.db/todos-os-pedidos)
      resumo (l.logica/resumo-por-usuario pedidos)]
  (println "Pedidos" pedidos)
  (println "Resumo" resumo)
  (println "Ordenado" (sort-by :valor-total resumo))
  (println "Ordenado reverso" (reverse (sort-by :valor-total resumo)))
  (println "Ordenado por id" (sort-by :usuario resumo))
  (println "Total do pedido 1" (get-in (nth resumo 0) [:valor-total]))
  )

(defn resumo-por-usuario-ordenado
  [pedidos]
  (->> pedidos
       (l.logica/resumo-por-usuario)
       (sort-by :usuario)))

(defn top-2 [resumo] (take 2 resumo))

(let [pedidos (l.db/todos-os-pedidos)
      resumo (resumo-por-usuario-ordenado pedidos)]
  (println "Resumo:" resumo)
  (println "Top 2:" (top-2 resumo))
  (println "> 500:" (filter #(> (:valor-total %) 500) resumo))
  (println "Alguém gastou mais de 500?" (some #(> (:valor-total %) 500) resumo)))