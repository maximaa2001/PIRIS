import s from './Navbar.module.css'

const mapNavigationLink = [
    ['/', 'Clients']
]

export const Navbar = () => {
    return(
        <nav className={s.wrapper}>
            {mapNavigationLink.map((item) => (
                <a href={item[0]} className={s.link}>{item[1]}</a>
            ))}
        </nav>
    )
}