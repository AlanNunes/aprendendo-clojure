(ns aprendendo-clojure.aula3)

(defn aplica-desconto?
  [valor-bruto]
  (> valor-bruto 100))

(defn valor-descontado
  "Retorna o valor com desconto de 10% se deve aplicar desconto."
  [aplica? valor-bruto]
  (if (aplica? valor-bruto)
    (let [taxa-desconto (/ 10 100)
          desconto (* valor-bruto taxa-desconto)]
      (- valor-bruto desconto))
    valor-bruto))

(println (valor-descontado aplica-desconto? 100))
(println (valor-descontado aplica-desconto? 1000))
(println (valor-descontado #(> % 100) 300))