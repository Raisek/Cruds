import React, {useState, useEffect} from 'react'


const ContactForm = (props) => {

    const initialFieldValues = {
        fullName: '',
        genero: '',
       
    }

    let [values, setValues] = useState(initialFieldValues)
    
    useEffect( () => {
        if(props.currentId == '') {
            setValues({
                ...initialFieldValues
            })
        } else {
            setValues({
                ...props.contactObjects[props.currentId]
            })
        }
    }, [props.currentId, props.contactObjects] )


    const handleInputChange = e => {
        let { name, value} = e.target
        
        setValues({
            ...values,
            [name]: value
        })
    }
    
    const handleFormSubmit = e => {
        e.preventDefault()
        props.addOrdit(values)
    }
    

    return (
        <form autoComplete="off" onSubmit={handleFormSubmit}>
            <div className="form-group input-group">
                <div className="input-group-prepend">
                    <div className="input-group-text">
                        <i className="fas fa-user"></i>
                    </div>
                </div>
                <input className="form-control" placeholder="Nome da banda" name="fullName" value={values.fullName} 
                onChange={handleInputChange} />
            </div>

            <div className="form-row">
                <div className="form-group input-group col-md-6">
                    <div className="input-group-prepend">
                        <div className="input-group-text">
                            <i className="fas fa-user"></i>
                        </div>
                    </div>
                    <input className="form-control" placeholder="genero" name="genero" value={values.genero} onChange={handleInputChange} />
                </div>


                <div className="form-group input-group col-md-6">
                    <div className="input-group-prepend">
                        <div className="">
                            <i className=""></i>
                        </div>
                    </div>
                    
                </div>
            </div>
            

            <div className="form-group mt-2">
                <input type="submit" value={props.currentId == '' ? "Salvar" : "Atualizar"} className="btn btn-primary btn-block" />
            </div>
        </form>
    )
}

export default ContactForm