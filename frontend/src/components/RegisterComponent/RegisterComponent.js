import './styles.css'
import React, { useEffect, useState } from 'react';
import  secureLocalStorage  from  "react-secure-storage";
import makeRequest from '../../functions/request';


const RegisterComponent = () => {

    const register = () => {
        const email = document.getElementById('email').value;
        const username = document.getElementById('username').value;
        const password = document.getElementById('password').value;
        const firstName = document.getElementById('firstName').value;
        const lastName = document.getElementById('lastName').value;
        const date = document.getElementById('bdate').value;
        const address = document.getElementById('address').value;
        const phone = document.getElementById('phone').value;
        const gender = document.getElementById('gender').value;
        const role = document.getElementById('role').value;

        if (!email || !username || !password || !firstName || !lastName || !date || !address || !phone || !gender || !role) {
            displayMessage("Please fill in all fields.");
            return;
        }

        const body = JSON.stringify({
            enabled: true,
            email: email,
            username: username,
            password: password,
            gender: gender,
            user_class: role,
            first_name: firstName,
            last_name: lastName,
            phone_no: phone,
            address: address,
            birthdate: date,
        });

        displayMessage("Registering...");

        makeRequest('Register/User', 'POST', body)
            .then(response => {
                window.location.href = "/verification";
            })
            .catch(error => {
                console.error("Error logging in:", error);
                alert("Error logging in.");
            });

    }

    const displayMessage = (message) => {
        document.getElementById('display').innerHTML = message;
        document.getElementById('display').style.display = "block";
    }

    return(
        <>
    <div class="container signing-panel2">
        <div class="row d-flex d-xl-flex justify-content-center justify-content-xl-center">
            <div class="col-sm-12 col-lg-10 col-xl-9 col-xxl-7 bg-white shadow-lg">
                <div class="p-5">
                    <div class="text-center">
                        <h4 class="text-dark mb-4">New Account</h4>
                    </div>

                    <div className="alert alert-primary text-center" id="display" style={{display: "none"}}></div>
                    <div class="user">
                        <div class="mb-3"><input class="form-control form-control-user" type="text" placeholder="Username" required="" id="username" /></div>
                        <div class="mb-3"><input class="form-control form-control-user" type="email" id="email" placeholder="Email Address" required="" /></div>
                        <div class="row mb-3">
                            <div class="col-sm-6 mb-3 mb-sm-0"><input class="form-control form-control-user" type="password" id="password" placeholder="Password" required="" /></div>
                            <div class="col-sm-6"><input class="form-control form-control-user" type="date" id="bdate" placeholder="Repeat Password" required="" /></div>
                        </div>
                        <div class="row mb-3">
                            <div class="col-sm-6 mb-3 mb-sm-0"><input class="form-control form-control-user" type="text" placeholder="First Name" required="" id="firstName" /></div>
                            <div class="col-sm-6"><input class="form-control form-control-user" type="text" placeholder="Last Name" required="" id="lastName" /></div>
                        </div>
                        <div class="row mb-3">
                            <div class="col-sm-6 mb-3 mb-sm-0"><input class="form-control form-control-user" type="text" placeholder="Address" required="" id="address" /></div>
                            <div class="col-sm-6"><input class="form-control form-control-user" type="text" placeholder="Phone Number" required="" id="phone" /></div>
                        </div>
                        <div class="row mb-3">
                            <div class="col-sm-6 mb-3 mb-sm-0">
                                <select id="gender" className="form-control form-control-user">
                                    <option value="">Gender</option>    
                                    <option value="M">Male</option>    
                                    <option value="F">Female</option>    
                                </select>    
                            </div>

                            <div class="col-sm-6 mb-3 mb-sm-0">
                                <select id="role" className="form-control form-control-user">
                                    <option value="Adopter">Adopter</option>    
                                    <option value="Manger">Manager</option>    
                                    <option value="Staff">Staff</option>    
                                    <option value="Admin">Admin</option>    
                                </select>    
                            </div>
                        </div>
                        <div class="row mb-3">
                        </div>
                        <button class="btn btn-primary d-block btn-user w-100" id="submitBtn" type="submit" onClick={register}>Register</button>
                        <hr />
                    </div>
                    <div class="text-center"><a class="small" href="/login">Already have an account? Login!</a></div>
                </div>
            </div>
        </div>
    </div>
        </>
    );
};

export default RegisterComponent;