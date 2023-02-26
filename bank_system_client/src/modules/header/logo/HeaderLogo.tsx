import s from './HeaderLogo.module.css'

export const HeaderLogo = () => {

    return(
    <figure>
        <a href={'/'} className={s.link}>
            <img
                 src={process.env.PUBLIC_URL + "/logo.svg"}
                 width='300'
                 height='100'
            />
        </a>
    </figure>
    )
}