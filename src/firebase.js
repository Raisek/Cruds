import firebase from 'firebase';

const firebaseConfig = {
  apiKey: "AIzaSyBp2dO76RM75JlnUOMOlL2EjF5Rszqs1WY",
  authDomain: "reactcrud-8c060.firebaseapp.com",
  databaseURL: "https://reactcrud-8c060-default-rtdb.firebaseio.com",
  projectId: "reactcrud-8c060",
  storageBucket: "reactcrud-8c060.appspot.com",
  messagingSenderId: "862830583174",
  appId: "1:862830583174:web:33cfa70da7d2a573fc2007"


};
  // Initialize Firebase
let fireDb = firebase.initializeApp(firebaseConfig);

export default fireDb.database().ref()
