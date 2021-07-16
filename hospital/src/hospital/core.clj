(ns hospital.core
  (:use [clojure pprint])
  (:require [hospital.model :as h.model]))

(let [hopital-do-alan (h.model/novo-hospital)]
  (pprint hopital-do-alan))