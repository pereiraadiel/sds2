import React from 'react';
import './styles.css';
import { ReactComponent as Logo } from '../../assets/DSDelivery.svg';
import { Link } from 'react-router-dom';

const Navbar = () => {
  return (
    <nav className="main-navbar">
      <Logo/>
      <Link className="logo-text" to="/">DS Delivery</Link>
    </nav>
  );
}

export default Navbar;