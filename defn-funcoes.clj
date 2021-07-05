;; (defn imprime-mensagem []
;;   (println "Bem vindo(a) ao estoque!"))
;; (imprime-mensagem)

;; (defn valor-descontado
;;   "Retorna o valor com desconto de 10%"
;;   [valor-bruto]
;;   (* valor-bruto (- 1 0.10)))

;; (println (valor-descontado 1100))

;; (defn valor-descontado
;;   "Retorna o valor com desconto de 10%"
;;   [valor-bruto]
;;   (let [desconto (/ 10 100)]
;;     (* valor-bruto desconto)))

;; (println (valor-descontado 990))

;; (defn valor-descontado
;;   "Retorna o valor com desconto de 10%"
;;   [valor-bruto]
;;   (let [taxa-desconto (/ 10 100),
;;         desconto (* valor-bruto taxa-desconto)]
;;     (println "Calculando desconto de" desconto)
;;     (- valor-bruto desconto)))

;; (println (valor-descontado 100))

(defn valor-descontado
  "Retorna o valor com desconto de 10% se o valor bruto for superior a 100"
  [valor-bruto]
  (if (> valor-bruto 100)
    (let [taxa-desconto (/ 10 100)
          desconto (* valor-bruto taxa-desconto)]
      (println "Calculando desconto de" desconto)
      (- valor-bruto desconto))
    valor-bruto))

(println (valor-descontado 100))
(println (valor-descontado 120))