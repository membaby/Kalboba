import './styles.css'
import React, { useEffect, useState } from 'react';
import  secureLocalStorage  from  "react-secure-storage";


const AdoptionComponent = () => {

    return(
        <>
    <div class="container signing-panel2">
        <div class="row d-flex d-xl-flex justify-content-center justify-content-xl-center">
            <div class="col-sm-12 col-lg-10 col-xl-9 col-xxl-7 bg-white shadow-lg">
                <div class="p-5">
                    <div class="text-center">
                        <h4 class="text-dark mb-4">Adoption Form</h4>
                    </div>
                    <div>
                        <div>You are adopting Tweety from Feathered Friends Sanctuary shelter.</div>
                    </div>
                    <form class="user mt-3">
                        <div class="mb-3"><input class="form-control form-control-user" type="text" placeholder="Name" required="" /></div>
                        <div class="row mb-3">
                            <div class="col-sm-6 mb-3 mb-sm-0"><input class="form-control form-control-user" type="text" id="phone" placeholder="Phone Number" required="" /></div>
                            <div class="col-sm-6"><input class="form-control form-control-user" type="text" id="address" placeholder="Address" required="" /></div>
                        </div>
                        <div class="mb-3">
                            <textarea class="form-control form-control-user" type="text" id="reason" placeholder="Why do you want to adopt this pet?" required=""></textarea>
                        </div>
                        <div class="mb-3">
                            {/* Agreement */}
                            <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault" required="" /> 
                            <label class="form-check-label mx-2" for="flexCheckDefault">I agree to allow a representative from the shelter to conduct a home visit</label> <br/>
                            <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault-1" required="" /> 
                            <label class="form-check-label mx-2" for="flexCheckDefault-1">I agree to spay or neuter the adopted pet</label> <br/>
                            <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault-2" required="" /> 
                            <label class="form-check-label mx-2" for="flexCheckDefault-2">I agree to provide regular veterinary care to any health issues that may arise.</label>
                        </div>
                        <button class="btn btn-primary d-block btn-user w-100" id="submitBtn" type="submit">Submit</button>
                        <hr />
                    </form>
                </div>
            </div>
        </div>
    </div>
        </>
    );
};

export default AdoptionComponent;