import { HeaderLogo } from '../logo/HeaderLogo'
import { Navbar } from '../navbar/Navbar'
import s from './Header.module.css'

export const Header = () => {
    return(
        <header className={s.wrapper}>
            <HeaderLogo/>
            <Navbar/>
        </header>
    )
}