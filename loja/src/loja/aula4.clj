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

(let [pedidos (l.db/todos-os-pedidos)
      resumo (resumo-por-usuario-ordenado pedidos)]
  (println "Resumo" resumo))