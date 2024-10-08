(ns middleware 
  "https://clerk.com/docs/references/nextjs/clerk-middleware"
  (:require ["@clerk/nextjs/server" :refer [clerkMiddleware]]))

(def default clerkMiddleware)

(def config
  (js* "{
  matcher: [
    // Skip Next.js internals and all static files, unless found in search params
    '/((?!_next|[^?]*\\.(?:html?|css|js(?!on)|jpe?g|webp|png|gif|svg|ttf|woff2?|ico|csv|docx?|xlsx?|zip|webmanifest)).*)',
    // Always run for API routes
    '/(api|trpc)(.*)',
  ],
}"))
