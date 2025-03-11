package com.example.kintaipointver2.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.kintaipointver2.entity.User;

public class UserDetailsImpl implements UserDetails {
	private final User user;
	private final Collection<GrantedAuthority> authorities;
	
	public UserDetailsImpl(User user, Collection<GrantedAuthority> authorities) {
		this.user = user;
		this.authorities = authorities;
	}
	
	public User getUser() {
		return user;
	}
	
	//ハッシュ化済みのパスワードを返す
	@Override
	public String getPassword() {
		return user.getPassword();
	}
	
	//ログイン時に利用するユーザー名（メールアドレス）を返す
	@Override
	public String getUsername() {
		return user.getEmail();
	}
	
	//ロールのコレクションを返す
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	
	//アカウント期限切れの有無＝作成しない機能なので、trueを返す
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	//ユーザーのロックの有無＝作成しない機能なので、trueを返す
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	//パスワード期限切れの有無＝作成しない機能なので、trueを返す
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	//ユーザーの有効性＝メール認証の機能
	@Override
	public boolean isEnabled() {
		return user.getEnabled();
	}
}
