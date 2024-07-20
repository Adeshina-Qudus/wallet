package com.semicolon.wallet.data.repositories;

import com.semicolon.wallet.data.models.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet,Long> {


}
