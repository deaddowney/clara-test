(ns clara.run-examples
  (:gen-class)
  (require [clara.examples.shopping :as shopping]))

(defn -main []
  (println "Shopping examples:")
  (shopping/run-examples))
