import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import './App.css';

import NavbarComponent from './components/NavbarComponent/NavbarComponent';
import FooterComponent from './components/FooterComponent/FooterComponent';
import HomepageComponent from './components/HomepageComponent/HomepageComponent';
import RegisterComponent from './components/RegisterComponent/RegisterComponent';
import LoginComponent from './components/LoginComponent/LoginComponent';
import SearchComponent from './components/SearchComponent/SearchComponent';
import AdoptionComponent from './components/AdoptionComponent/AdoptionComponent';

function App() {
  return (
    <Router>
      <div className="fixed-top">
        <NavbarComponent />
      </div>
      <div className="empty_block d-block w-100"></div>

      <div className="mb-5 container">
        
        <Routes>
          <Route path='/' element={ <HomepageComponent/> } />
          <Route path='/logout' element={ <HomepageComponent/> } />
          <Route path='/login' element={ <LoginComponent/> } />
          <Route path='/register' element={ <RegisterComponent/> } />
          <Route path='/adopt' element={ <SearchComponent/> } />
          <Route path='/adopt/:id' element={ <AdoptionComponent/> } />
        </Routes>
    
      <FooterComponent />
      </div>
    </Router>
  )
}

export default App;

