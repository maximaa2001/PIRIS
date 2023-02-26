import { HeaderLogo } from '../../modules/header/logo/HeaderLogo'
import { Navbar } from '../../modules/header/navbar/Navbar'
import s from './Header.module.css'

export const Header = () => {
    return(
        <header className={s.wrapper}>
            <HeaderLogo/>
            <Navbar/>
        </header>
    )
}