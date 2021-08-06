(ns hospital2.aula4
  (:use clojure.pprint))

(defmulti hello-world
          (fn [[id lang]] (get lang :name)))

(defmethod hello-world "C#" [params]
  (println "System.Console.WriteLine(\"Hello World!\")"))

(defmethod hello-world "Python" [params]
  (println "print(\"Hello World!\")"))

(defmethod hello-world "Javascript" [params]
  (println "console.log(\"Hello World!\")"))

(defmethod hello-world "Clojure" [params]
  (println "(println \"Hello World!\")"))

(def langs {:lang1 {:name "Python"}, :lang2 {:name "Clojure"}, :lang3 {:name "Javascript"}, :lang4 {:name "Python"}, :lang5 {:name "C#"}})

(map hello-world langs)