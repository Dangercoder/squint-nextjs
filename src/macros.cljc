(ns macros)

;; https://nextjs.org/docs/app/building-your-application/data-fetching/server-actions-and-mutations
(defmacro defsa
  [name args & body]
  `(defn ~name ~args
       (js* "'use server'")
       ~@body))