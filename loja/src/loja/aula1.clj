(ns loja.aula1)

(defn conta
  ([elementos] (conta 0 elementos))
  ([valor elementos]
   (if (seq elementos)
     (recur (inc valor) (next elementos))
     valor)))

(println (conta 0 ["alan" "karynne" "luan" "tainan" "joãozinho" "thalita"]))

(println "Contagem com a função loop:")

(defn conta
  [elementos]
  (loop
    [valor 0
     elementos-restantes elementos]
    (if (seq elementos-restantes)
      (recur (inc valor) (next elementos-restantes))
      valor)))

(println (conta ["alan" "karynne" "luan" "tainan" "joãozinho" "thalita"]))
(println (conta []))