import './styles.css'
import React, { useEffect, useState } from 'react';
import  secureLocalStorage  from  "react-secure-storage";


const NavbarComponent = () => {

    const [links, setLinks] = useState([
        {'name': 'Home', 'Link': '/'},
        {'name': 'Pet Adoption', 'Link': '/adopt'},
    ])
    const [role, setRole] = useState(secureLocalStorage.getItem('role'))
    useEffect(() => {
        let tempLinks = [...links]
        if (role === 'admin') {
            tempLinks.push({'name': 'Admin', 'Link': '/admin'})
            tempLinks.push({'name': 'Logout', 'Link': '/logout'})
        } else if (role === 'shelter') {
            tempLinks.push({'name': 'Shelter', 'Link': '/shelter'})
            tempLinks.push({'name': 'Logout', 'Link': '/logout'})
        } else if (role === null) { 
            tempLinks.push({'name': 'Login', 'Link': '/login'})
        }
        setLinks(tempLinks)
    }, [role]);

    return(
        <>
        <nav className="navbar navbar-expand-md bg-body py-3 ">
            <div className="container">
                <a className="navbar-brand d-flex align-items-center" href="/">
                    <img src="/assets/img/logo.png" className="logo" />
                </a>
                <button data-bs-toggle="collapse" className="navbar-toggler" data-bs-target="#navcol-2">
                    <span className="visually-hidden">Toggle navigation</span>
                    <span className="navbar-toggler-icon"></span>
                </button>
                <div className="collapse navbar-collapse" id="navcol-2">
                    <ul className="navbar-nav ms-auto">
                        {links.map((link, index) => (
                            <li className="nav-item" key={index}>
                                <a className="nav-link" href={link.Link}>{link.name}</a>
                            </li>
                        ))}
                    </ul>
                    {role === null ? (
                        <a className="btn btn-primary ms-md-2" role="button" href="/register">Register</a>
                    ) : (
                        <a className="btn btn-primary ms-md-2" role="button" href="/applications">Applications</a>
                    )}
                </div>
            </div>
        </nav>
        </>
    );
};

export default NavbarComponent;