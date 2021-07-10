(ns loja.aula1)

(defn conta
  ([elementos] (conta 0 elementos))
  ([valor elementos]
   (if (seq elementos)
     (recur (inc valor) (next elementos))
     valor)))

(println (conta 0 ["alan" "karynne" "luan" "tainan" "joãozinho" "thalita"]))