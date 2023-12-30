import './styles.css'
import React, { useEffect, useState } from 'react';
import makeRequest from '../../functions/request'
import { store as Store } from 'react-notifications-component';

// TEST
// Store.addNotification({
//     title: "Wonderful!",
//     message: "teodosii@react-notifications-component",
//     type: "success",
//     insert: "top",
//     container: "top-right",
//     animationIn: ["animate__animated", "animate__fadeIn"],
//     animationOut: ["animate__animated", "animate__fadeOut"],
//     dismiss: {
//       duration: 5000,
//       onScreen: true
//     }
//   });
  

const LoginComponent = () => {
    
    const login = () => {
        const email = document.getElementById('email').value;
        const password = document.getElementById('password').value;
        const body = JSON.stringify({
            email: email,
            password: password
        });
        // makeRequest('login', 'POST', body)
        //     .then(response => {
        //         secureLocalStorage.setItem("token", response.token);
        //         secureLocalStorage.setItem("user", JSON.stringify(response.user));
        //         window.location.href = "/home";
        //     })
        //     .catch(error => {
        //         console.error("Error logging in:", error);
        //         alert("Error logging in.");
        //     });

    }

    return(
        <>
        <div class="container signing-panel">
            <div class="row d-flex d-xl-flex justify-content-center justify-content-xl-center">
                <div class="col-sm-12 col-lg-6 col-xl-4 col-xxl-4 bg-white shadow-lg">
                    <div class="p-5">
                        <div class="text-center">
                            <h4 class="text-dark mb-4">Login</h4>
                        </div>
                        <div class="user">
                            <div class="mb-3"><input class="form-control form-control-user" type="email" id="email" placeholder="Email Address" required="" /></div>
                            <div class="mb-3"><input class="form-control form-control-user" type="password" id="password" placeholder="Password" required="" /></div>
                            <div class="row mb-3">
                            </div>
                            <button class="btn btn-primary d-block btn-user w-100" onClick={login}>Login</button>
                            <hr />
                        </div>
                        <div class="text-center"></div>
                        <div class="text-center"><a class="small" href="/register">Don't have an account? Register!</a></div>
                    </div>
                </div>
            </div>
        </div>
        </>
    );
};

export default LoginComponent;