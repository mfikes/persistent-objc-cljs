(ns persistent-perf.view-controller
  (:require-macros [goby.macros :refer [defui]]))

(defui obj-c-time-label cljs-time-label)

(defn- handle-view-did-load! []
  (set! (.-text @obj-c-time-label) "123")
  (set! (.-text @cljs-time-label) "456"))
