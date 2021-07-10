(ns aprendendo-clojure.aula4)

(def precos [30 700 1000])

(defn dobra-valor
  [valor]
  (* valor 2))

;(println (precos 0))
;(println (update precos 0 dobra-valor))
;(println (update precos 0 dobra-valor))

;(println (map dobra-valor precos))

(defn aplica-desconto?
  [valor-bruto]
  (> valor-bruto 100))

(defn valor-descontado
  "Retorna o valor com desconto de 10% se deve aplicar."
  [valor-bruto]
  (if (aplica-desconto? valor-bruto)
    (let [taxa-desconto (/ 10 100)
          desconto (* valor-bruto taxa-desconto)]
      (- valor-bruto desconto))
      valor-bruto))

;(println (map valor-descontado precos))
(println "Preços que devem receber desconto:" (filter aplica-desconto? precos))
(println "Preços com valor descontado:" (map valor-descontado (filter aplica-desconto? precos)))
(println "Valor total antes do desconto:" (reduce + (filter aplica-desconto? precos)))
(println "Valor total depois do desconto:" (reduce + (map valor-descontado (filter aplica-desconto? precos))))
