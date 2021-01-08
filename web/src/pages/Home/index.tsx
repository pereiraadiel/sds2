import React from 'react';
import './styles.css';
import Navbar from '../../components/Navbar';
import { Link } from 'react-router-dom';
import { ReactComponent as DeliveringImage } from '../../assets/Delivering.svg';

const Home = () => {
  return (
    <div className="home-container">
      <Navbar/>
      <div className="home-content">
        <div className="home-actions">
          <h1 className="home-title">
            Faça seu pedido<br/>que entregamos<br/>para você!!!
          </h1>
          <h2 className="home-subtitle">
            Escolha seu pedido e em poucos minutos<br/>levaremos na sua porta
          </h2>
          <Link className="home-btn-order" to="/">Fazer pedido</Link>
        </div>
        <div className="home-image">
          <DeliveringImage/>
        </div>
      </div>
    </div>
  );
}

export default Home;