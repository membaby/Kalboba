import './styles.css'
import React, { useEffect, useState } from 'react';
import  secureLocalStorage  from  "react-secure-storage";


const RegisterComponent = () => {

    return(
        <>
    <div class="container signing-panel2">
        <div class="row d-flex d-xl-flex justify-content-center justify-content-xl-center">
            <div class="col-sm-12 col-lg-10 col-xl-9 col-xxl-7 bg-white shadow-lg">
                <div class="p-5">
                    <div class="text-center">
                        <h4 class="text-dark mb-4">New Account</h4>
                    </div>
                    <form class="user">
                        <div class="mb-3"><input class="form-control form-control-user" type="text" placeholder="Username" required="" /></div>
                        <div class="mb-3"><input class="form-control form-control-user" type="email" id="email" placeholder="Email Address" required="" /></div>
                        <div class="row mb-3">
                            <div class="col-sm-6 mb-3 mb-sm-0"><input class="form-control form-control-user" type="password" id="password" placeholder="Password" required="" /></div>
                            <div class="col-sm-6"><input class="form-control form-control-user" type="password" id="verifyPassword" placeholder="Repeat Password" required="" /></div>
                        </div>
                        <div class="row mb-3">
                            <div class="col-sm-6 mb-3 mb-sm-0"><input class="form-control form-control-user" type="text" placeholder="First Name" required="" /></div>
                            <div class="col-sm-6"><input class="form-control form-control-user" type="text" placeholder="Last Name" required="" /></div>
                        </div>
                        <div class="row mb-3">
                            {/* <p id="emailErrorMsg" class="text-danger" style="display:none;">Paragraph</p>
                            <p id="passwordErrorMsg" class="text-danger" style="display:none;">Paragraph</p> */}
                        </div>
                        <button class="btn btn-primary d-block btn-user w-100" id="submitBtn" type="submit">Register</button>
                        <hr />
                    </form>
                    <div class="text-center"><a class="small" href="/login">Already have an account? Login!</a></div>
                </div>
            </div>
        </div>
    </div>
        </>
    );
};

export default RegisterComponent;