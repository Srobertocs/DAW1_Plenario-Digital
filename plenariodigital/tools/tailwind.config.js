/** @type {import('tailwindcss').Config} */
module.exports = {
  //Caminho por onde o tailwind irá buscar por classes css
  content: [
    "../src/main/resources/templates/**/*.{html,js,ts,jsx,tsx}",
  ],
  theme: {
    extend: {},
  },
  plugins: [],
}