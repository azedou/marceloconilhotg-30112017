import React from 'react'
import { Field, reduxForm } from 'redux-form'

let StudentReduxForm = props => {
  const { handleSubmit } = props
  return (
    <form onSubmit={ handleSubmit }>
      <div>
        <label htmlFor="ra">RA</label>
        <Field name="ra" component="input" type="text" />
      </div>
      <div>
        <label htmlFor="name">Name</label>
        <Field name="name" component="input" type="text" />
      </div>
      <div>
        <label htmlFor="email">Email</label>
        <Field name="email" component="input" type="email" />
      </div>
      <div>
        <label htmlFor="course">Course</label>
        <Field name="course" component="input" type="text" />
      </div>
      <div>
        <label htmlFor="cycle">Cycle</label>
        <Field name="cycle" component="input" type="text" />
      </div>
      <div>
        <label htmlFor="theme">Theme</label>
        <Field name="theme" component="input" type="text" />
      </div>
      <div>
        <label htmlFor="discipline">Discipline</label>
        <Field name="discipline" component="input" type="text" />
      </div>
      <button type="submit">Submit</button>
    </form>
  )
}

StudentReduxForm = reduxForm({
  // a unique name for the form
  form: 'student'
})(StudentReduxForm)
export default StudentReduxForm;