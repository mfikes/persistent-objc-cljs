(ns persistent-perf.view-controller
  (:require-macros [goby.macros :refer [defui]]))

(defui obj-c-time-label cljs-time-label run-tests-button)

(defn- run-cljs-test []
  (loop [i 0
         m (transient {})]
    (if (< i 1000000)
      (recur (inc i)
             (conj! m [i i]))
      (persistent! m))))

(defn- run-tests! []
  (println "Running tests...")

  (let [start (.currentTime @view-controller)
        _ (.runTests @view-controller)
        end (.currentTime @view-controller)]
    (set! (.-text @obj-c-time-label) (- end start)))

  (let [start (.currentTime @view-controller)
        _ (run-cljs-test)
        end (.currentTime @view-controller)]
    (set! (.-text @cljs-time-label) (- end start)))

  (println "Finished running tests."))

(defn- handle-view-did-load! []
  (set! (.-text @obj-c-time-label) "-")
  (set! (.-text @cljs-time-label) "-")
  (.setTouchUpInsideCallback @run-tests-button run-tests!))
