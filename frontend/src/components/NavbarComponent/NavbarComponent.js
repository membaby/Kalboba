import './styles.css'
import React, { useEffect, useState } from 'react';
import  secureLocalStorage  from  "react-secure-storage";

const NavbarComponent = () => {

    const defaultLinks = [
        {'name': 'Home', 'Link': '/'},
        {'name': 'Pet Adoption', 'Link': '/adopt'},
    ]

    const [links, setLinks] = useState([])
    const role = secureLocalStorage.getItem('user_class');
    const [notifications, setNotifications] = useState([
        {'title': 'Application Status', 'body': 'Your application for Fluffy has been approved!'},
        {'title': 'Application Status', 'body': 'Your application for Fluffy has been approved!'},
        {'title': 'Application Status', 'body': 'Your application for Fluffy has been approved!'},
    ]);
    useEffect(() => {
        let tempLinks = [...defaultLinks]
        if (role === 'Admin') {
            tempLinks.push({'name': 'Admin', 'Link': '/admin'})
            tempLinks.push({'name': 'Logout', 'Link': '/logout'})
        } else if (role === 'Manager') {
            tempLinks.push({'name': 'Shelter', 'Link': '/shelter'})
            tempLinks.push({'name': 'Logout', 'Link': '/logout'})
        } else if (role === 'Staff') {
            tempLinks.push({'name': 'Applications', 'Link': '/apps'})
            tempLinks.push({'name': 'Logout', 'Link': '/logout'})
        } else if (role === 'Adopter') {
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
                        <>
                            <a className="btn btn-primary ms-md-2" role="button" href="/applications">Applications</a>
                            <div className={`notification-badge text-center ${notifications.length ? "bg-danger" : "bg-primary"}`}>{notifications.length}
                                <div className="notifications">
                                    {notifications.map((notification) => (
                                        <div className="notification">
                                            <div className="notification-title">{notification.title}</div>
                                            <div className="notification-body">{notification.body}</div>
                                            <hr/>
                                        </div>
                                    ))}
                                </div>
                            </div>
                        </>
                    )}
                </div>
            </div>
        </nav>
        </>
    );
};

export default NavbarComponent;