# Squint-cljs + NextJS(14.2) + Clerk (auth)

## Some cool things to note:
- This is a fullstack NextJS app with auth using Clerk and ClojureScript(squint-cljs)
- macros allows us to do useful things like improving the declaration of NextJS server-actions - check out the defsa macro in the macros.cljc file

### Run it 
Create a clerk account (https://clerk.com/) and get the publishable key and secret key. Use the nextjs template.
Set the values in the `.env.local` file

Then:
1. `npm install`
2. `bb dev`    
3. `npm run dev`
