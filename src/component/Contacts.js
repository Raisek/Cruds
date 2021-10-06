import React, { useEffect, useState } from 'react'
import ContactForm from './ContactForm'
import fireDb from '../firebase' 

const axios = require('axios').default;

axios.get('/api/banda')
  .then(function (response) {
    
    console.log(response);
  })
  .catch(function (error) {
   
    console.log(error);
  })

  axios.post('/user', {
    fullName: '',
    genero: ''
  })
  .then(function (response) {
    console.log(response);
  })
  .catch(function (error) {
    console.log(error);
  });


const Contacts = () => {

    let [contactObjects, setContactObjects] = useState({})

    let [currentId, setCurrentId] = useState('')
    
    
    useEffect( () => {
        fireDb.child('bandas').on('value', dbPhoto => {
            if(dbPhoto.val() != null) {
                setContactObjects({
                    ...dbPhoto.val()
                })
            } else {
                setContactObjects({})
            }
        })
    }, [] )


    
  
    
    const addOrdit = obj => {
        
        if (currentId === '') {
            
            fireDb.child('bandas').push(
                obj,
                err => {
                    if(err) {
                        console.log(err)
                    }else {
                        setCurrentId('')
                    }
                }
            )
        } else {
            fireDb.child(`bandas/${currentId}`).set(
                obj,
                err => {
                    if(err)
                        console.log(err)
                }
            )
        }
    }


    

    const onDelete = key => {
        if( window.confirm('Tem certeza que deseja deletar?') ) {
            fireDb.child(`bandas/${key}`).remove(
                err => {
                    if(err)
                        console.log(err)
                }
            )
        }
    }
    return (
        <React.Fragment>

            <div class="jumbotron">
                <h1 class="display-4 text-center">Cadastro de bandas</h1>
            </div>

            <div className="row">
                <div className="col-md-5">
                    <ContactForm {...( {addOrdit, currentId, contactObjects} )} />
                </div>

                <div className="col-md-7">
                    <table className="table table-borderless table-stripped">
                        <thead className="thead-light"> 
                            <tr>
                                <th> Nome da banda </th>
                                <th> Genero </th>
                                <th>          </th>
                                <th> Ações </th>
                            </tr>
                        </thead>

                        <tbody>
                            {
                                Object.keys(contactObjects).map( id => {
                                    return <tr key={id}>
                                        <td> {contactObjects[id].fullName} </td>
                                        <td> {contactObjects[id].genero} </td>
                                        <td> {contactObjects[id].email} </td>

                                        <td>
                                            <a className="btn btn-primary" onClick={ () => {setCurrentId(id)} }>
                                                <i className="fas fa-pencil-alt"></i>
                                            </a>
                                            <a className="btn btn-danger" onClick={ () => onDelete(id)}>
                                            <i className="far fa-trash-alt"></i>
                                            </a>
                                        </td>
                                    </tr>
                                    
                                })
                            }
                        </tbody>
                    </table>
                </div>
            </div>
        </React.Fragment>
    )
}

export default Contacts