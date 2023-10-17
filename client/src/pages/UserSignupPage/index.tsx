import axios from "axios";
import { ChangeEvent, useState } from "react"

export function UserSignupPage() {

    const [user, setUser] = useState({
        displayName: null,
        username: null,
        password: null,
    });
    const [errors, setErrors] = useState({
        displayName: null,
        username: null,
        password: null,
    });

    function onChange(event: ChangeEvent<HTMLInputElement>) {
        const {name, value} = event.target;

        setUser(previousState => ({
            ...previousState,
            [name]: value,
        }));

        setErrors(previousState => ({
            ...previousState,
            [name]: undefined,
        }));
    }

    function onClickSighup() {
        console.log(user);

        axios.post("http:localhost/users", user)
            .then(response => {
                console.log(response.data);
            })
            .catch(e => {
                if (e.response.data.validationErros) {
                    setErrors(e.response.data.validationErros);
                }

                console.error(e);
            });
    }

    return (
        <>
            <main className="container">
                <form>
                    <div className="text-center">
                        <h1>User Signup Page</h1>
                    </div>

                    <div className="form-floating  mb-3">
                        <input 
                            name="displayName"
                            className={errors.displayName ? "form-control is-invalid" : "form-control"}
                            type="text"
                            placeholder="Informe seu nome"
                            onChange={onChange}
                        />

                        <label htmlFor="displayName">Informe seu nome</label>
                        {errors.displayName && <div className="invalid-feedback">{errors.displayName}</div>}
                    </div>

                    <div className="form-floating mb-3">
                        <input 
                            name="username"
                            className={errors.username ? "form-control is-invalid" : "form-control"}
                            type="text"
                            placeholder="Informe seu usuário"
                            onChange={onChange}
                        />

                        <label htmlFor="displayName">Informe seu usuário</label>
                        {errors.username && <div className="invalid-feedback">{errors.username}</div>}
                    </div>

                    <div className="form-floating mb-3">
                        <input 
                            name="password"
                            className={errors.password ? "form-control is-invalid" : "form-control"}
                            type="password"
                            placeholder="Informe sua senha"
                            onChange={onChange}
                        />

                        <label htmlFor="displayName">Informe sua senha</label>
                        {errors.password && <div className="invalid-feedback">{errors.password}</div>}
                    </div>

                    <button
                        className="w-100 btn btn-lg btn-primary mb-3"
                        type="button"
                        onClick={onClickSighup}>
                        Cadastrar
                    </button>
                </form>
            </main>
        </>
    )
}