import './styles.css'
import React, { useEffect, useState } from 'react';
import  secureLocalStorage  from  "react-secure-storage";


const LoginComponent = () => {

    return(
        <>
        <div class="container signing-panel">
            <div class="row d-flex d-xl-flex justify-content-center justify-content-xl-center">
                <div class="col-sm-12 col-lg-6 col-xl-4 col-xxl-4 bg-white shadow-lg">
                    <div class="p-5">
                        <div class="text-center">
                            <h4 class="text-dark mb-4">Login</h4>
                        </div>
                        <form class="user">
                            <div class="mb-3"><input class="form-control form-control-user" type="text" placeholder="Username" required="" /></div>
                            <div class="mb-3"><input class="form-control form-control-user" type="email" id="email" placeholder="Email Address" required="" /></div>
                            <div class="row mb-3">
                                {/* <p id="emailErrorMsg" class="text-danger" style="display:none;">Paragraph</p>
                                <p id="passwordErrorMsg" class="text-danger" style="display:none;">Paragraph</p> */}
                            </div>
                            <button class="btn btn-primary d-block btn-user w-100" id="submitBtn" type="submit">Login</button>
                            <hr />
                        </form>
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