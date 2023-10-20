import React from 'react'
import ReactDOM from 'react-dom/client'
import 'bootstrap/dist/css/bootstrap.css'
//import './index.css'

import { UserSignupPage } from './pages/UserSignupPage'

ReactDOM.createRoot(document.getElementById('root')!).render(
  <React.StrictMode>
    <UserSignupPage />
  </React.StrictMode>,
)
