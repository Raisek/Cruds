import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import axios from 'axios';



axios.get("http://localhost:8080/api/banda").then(function(resposta){
  console.log(resposta.headers)
}).catch(function(error){
  if(error){
    console.log(error)
  }
});

axios.post("http://localhost:8080/api/banda", {banda: "nomedabanda"})
axios.put("http://localhost:8080/api/banda", {banda: "nomedabanda"})


axios.get("http://localhost:8080/api/banda", {banda: "nomedabanda"})
axios.delete("http://localhost:8080/api/banda", {banda: "nomedabanda"})

axios.delete("http://localhost:8080/api/banda", {genero: "Genero"})





ReactDOM.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>,
  document.getElementById('root')
);

reportWebVitals();
