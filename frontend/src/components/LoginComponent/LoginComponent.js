import './styles.css'
import React, { useEffect, useState } from 'react';
import makeRequest from '../../functions/request'
import hashString from '../../functions/hashString';
import { store as Store } from 'react-notifications-component';
import secureLocalStorage from 'react-secure-storage';

const LoginComponent = () => {
    
    const login = () => {
        const email = document.getElementById('email').value;
        const password = document.getElementById('password').value;
        const body = JSON.stringify({
            username: email,
            password: hashString(password)
        });
        makeRequest('Login', 'POST', body)
            .then(response => {
                secureLocalStorage.setItem("id", response.id);
                secureLocalStorage.setItem("username", response.username);
                secureLocalStorage.setItem("email", response.email);
                secureLocalStorage.setItem("user_class", response.user_class);
                
                if (response.user_class === "Admin") {
                    window.location.href = "/admin";
                } else if (response.user_class === "Manager") {
                    window.location.href = "/shelter";
                } else if (response.user_class === "Adopter") {
                    window.location.href = "/adopt";
                } else if (response.user_class === "Staff") {
                    window.location.href = "/staff";
                }
            })
            .catch(error => {
                console.error("Error logging in:", error);
                alert("Error logging in.");
            });

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