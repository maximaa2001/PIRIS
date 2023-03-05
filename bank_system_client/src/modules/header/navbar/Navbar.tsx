import s from './Navbar.module.css'

const mapNavigationLink = [
    ['/', 'Clients'],
    ['/deposits', 'Deposits'],
    ['/credits', 'Credits']
]

export const Navbar = () => {
    return(
        <nav className={s.wrapper}>
            {mapNavigationLink.map((item) => (
                <a key={item[1]} href={item[0]} className={s.link}>{item[1]}</a>
            ))}
        </nav>
    )
}