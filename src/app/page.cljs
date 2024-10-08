(ns app.page
  (:require
   ["@clerk/nextjs/server" :refer [currentUser]]
   ["@clerk/nextjs" :refer [SignInButton SignOutButton]]
   ["@/components/username-form" :refer [UsernameForm]])
  (:require-macros [macros :refer [defsa]]))

(defsa ^:async updateUsername [username]
  (println "saving user on the server")
  (str "<clojure-slayer> " username))

(defn logged-out []
  #jsx [:div {:className "min-h-screen bg-blue-900 flex flex-col items-center justify-center p-4"}
        [:div {:className "relative w-full max-w-3xl aspect-square"}
         [:svg {:viewBox "0 0 100 100"
                :className "w-full h-full text-blue-300"
                :xmlns "http://www.w3.org/2000/svg"}
          [:path {:fill "currentColor"
                  :d "M50 10 C60 10 70 20 70 35 C70 50 60 65 50 80 C40 65 30 50 30 35 C30 20 40 10 50 10 Z"}]
          [:circle {:cx "45" :cy "30" :r "3" :fill "white"}]
          [:circle {:cx "55" :cy "30" :r "3" :fill "white"}]
          [:path {:fill "currentColor" :d "M30 40 Q25 60 10 70 Q15 60 20 50 Q25 40 30 40 Z"}]
          [:path {:fill "currentColor" :d "M70 40 Q75 60 90 70 Q85 60 80 50 Q75 40 70 40 Z"}]
          [:path {:fill "currentColor" :d "M40 70 Q35 80 25 85 Q30 80 35 75 Q40 70 40 70 Z"}]
          [:path {:fill "currentColor" :d "M60 70 Q65 80 75 85 Q70 80 65 75 Q60 70 60 70 Z"}]
          [:path {:fill "currentColor" :d "M45 75 Q40 85 35 95 Q40 90 45 85 Q50 80 50 80 Z"}]
          [:path {:fill "currentColor" :d "M55 75 Q60 85 65 95 Q60 90 55 85 Q50 80 50 80 Z"}]]]
        [SignInButton {:className "text-white font-bold uppercase text-lg border border-white rounded-full px-8 py-4 hover:bg-white hover:text-blue-900"}]
        [:p {:className "mt-4 text-blue-200 text-center"}
         "Welcome to Octopus Login. Dive into your account!"]])

(defn logged-in [user]
  #jsx [:div {:className "min-h-screen bg-blue-900 flex flex-col items-center justify-center p-4"}
        [:div {:className "relative w-full max-w-3xl aspect-square"}
         [:svg {:viewBox "0 0 100 100"
                :className "w-full h-full text-blue-300"
                :xmlns "http://www.w3.org/2000/svg"}
          [:path {:fill "currentColor"
                  :d "M50 10 C60 10 70 20 70 35 C70 50 60 65 50 80 C40 65 30 50 30 35 C30 20 40 10 50 10 Z"}]
          [:circle {:cx "45" :cy "30" :r "3" :fill "white"}]
          [:circle {:cx "55" :cy "30" :r "3" :fill "white"}]
          [:path {:fill "currentColor" :d "M30 40 Q25 60 10 70 Q15 60 20 50 Q25 40 30 40 Z"}]
          [:path {:fill "currentColor" :d "M70 40 Q75 60 90 70 Q85 60 80 50 Q75 40 70 40 Z"}]
          [:path {:fill "currentColor" :d "M40 70 Q35 80 25 85 Q30 80 35 75 Q40 70 40 70 Z"}]
          [:path {:fill "currentColor" :d "M60 70 Q65 80 75 85 Q70 80 65 75 Q60 70 60 70 Z"}]
          [:path {:fill "currentColor" :d "M45 75 Q40 85 35 95 Q40 90 45 85 Q50 80 50 80 Z"}]
          [:path {:fill "currentColor" :d "M55 75 Q60 85 65 95 Q60 90 55 85 Q50 80 50 80 Z"}]
          [:path {:fill "white" :d "M40 35 Q50 45 60 35 Q55 40 50 41 Q45 40 40 35 Z"}]]]
        [:div {:className "text-center mt-8"}
         [:h1 {:className "text-3xl font-bold text-white mb-4"}
          (str "Welcome, " (:fullName user) "!")]
         [:p {:className "text-blue-200 mb-6"}
          "You're now logged in to your account."]
         [UsernameForm {:handleSubmit updateUsername}]
         [SignOutButton {:className "mt-4 bg-blue-500 hover:bg-blue-600 text-white font-bold py-3 px-6 rounded-full text-xl shadow-lg transition-all duration-300 ease-in-out transform hover:scale-105"}]
         [:p {:className "mt-8 text-blue-200 text-center"}
          "Enjoy your time in the depths of our octopus-themed application!"] ]])

(defn ^:async Home []
  (if-let [user (js/await (currentUser))]
    (logged-in user)
    (logged-out)))

(def default Home)