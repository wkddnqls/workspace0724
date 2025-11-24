<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CREP 회원가입</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <style>
        /* Custom animations and styles */
        .spinner {
            animation: spin 1s linear infinite;
        }
        
        @keyframes spin {
            from {
                transform: rotate(0deg);
            }
            to {
                transform: rotate(360deg);
            }
        }

        /* Custom checkbox styling */
        .custom-checkbox {
            appearance: none;
            width: 1rem;
            height: 1rem;
            border: 2px solid #9ca3af;
            border-radius: 0.25rem;
            cursor: pointer;
            position: relative;
            flex-shrink: 0;
        }

        .custom-checkbox:checked {
            background-color: #ea580c;
            border-color: #ea580c;
        }

        .custom-checkbox:checked::after {
            content: '✓';
            position: absolute;
            color: white;
            font-size: 0.75rem;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
        }

        /* Smooth transitions */
        .transition-all {
            transition: all 0.3s ease;
        }

        /* Password strength bar animation */
        .strength-bar {
            transition: width 0.3s ease;
        }
    </style>
</head>
<body class="bg-gradient-to-br from-orange-50 via-white to-orange-100 dark:from-gray-900 dark:via-gray-800 dark:to-orange-950">
    <div class="min-h-screen flex items-center justify-center p-4">
        <div class="w-full max-w-md">
            <!-- Back to Landing Button -->
            <button 
                onclick="backToLanding()"
                class="mb-6 flex items-center gap-2 px-3 py-2 text-gray-700 hover:text-orange-600 hover:bg-orange-50 dark:text-gray-300 dark:hover:text-orange-400 dark:hover:bg-gray-800 rounded-lg transition-all"
            >
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                    <path d="m12 19-7-7 7-7"/>
                    <path d="M19 12H5"/>
                </svg>
                홈으로 돌아가기
            </button>

            <!-- Main Card -->
            <div class="border-2 shadow-2xl bg-white dark:bg-gray-800 border-gray-200 dark:border-gray-700 rounded-lg">
                <!-- Header -->
                <div class="space-y-4 text-center pb-6 pt-8 px-8">
                    <!-- Logo -->
                    <div class="flex justify-center">
                        <img
                            src="https://raw.githubusercontent.com/lucide-icons/lucide/main/icons/circle-user.svg"
                            alt="CREP Logo"
                            class="w-16 h-16 text-orange-600"
                        />
                    </div>

                    <div>
                        <h1 class="text-3xl font-semibold text-gray-900 dark:text-white">
                            <span class="text-orange-600 dark:text-orange-500">CREP</span> 시작하기
                        </h1>
                        <p class="mt-2 text-gray-600 dark:text-gray-400">
                            무료로 가입하고 크리에이터로서 성장하세요
                        </p>
                    </div>
                </div>

                <!-- Form -->
                <form id="signupForm" class="px-8 pb-6">
                    <div class="space-y-4">
                        <!-- Name Field -->
                        <div class="space-y-2">
                            <label for="name" class="text-sm font-medium text-gray-700 dark:text-gray-200">
                                이름
                            </label>
                            <div class="relative">
                                <svg class="absolute left-3 top-1/2 transform -translate-y-1/2 w-5 h-5 text-gray-400 dark:text-gray-500" xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                                    <path d="M19 21v-2a4 4 0 0 0-4-4H9a4 4 0 0 0-4 4v2"/>
                                    <circle cx="12" cy="7" r="4"/>
                                </svg>
                                <input
                                    id="name"
                                    type="text"
                                    placeholder="홍길동"
                                    class="w-full pl-10 pr-4 py-3 border border-gray-300 dark:border-gray-600 rounded-lg focus:outline-none focus:border-orange-500 focus:ring-2 focus:ring-orange-500 dark:bg-gray-700 dark:text-gray-100 dark:placeholder:text-gray-500"
                                    required
                                />
                            </div>
                        </div>

                        <!-- Email Field -->
                        <div class="space-y-2">
                            <label for="email" class="text-sm font-medium text-gray-700 dark:text-gray-200">
                                이메일
                            </label>
                            <div class="relative">
                                <svg class="absolute left-3 top-1/2 transform -translate-y-1/2 w-5 h-5 text-gray-400 dark:text-gray-500" xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                                    <rect width="20" height="16" x="2" y="4" rx="2"/>
                                    <path d="m22 7-8.97 5.7a1.94 1.94 0 0 1-2.06 0L2 7"/>
                                </svg>
                                <input
                                    id="email"
                                    type="email"
                                    placeholder="example@email.com"
                                    class="w-full pl-10 pr-4 py-3 border border-gray-300 dark:border-gray-600 rounded-lg focus:outline-none focus:border-orange-500 focus:ring-2 focus:ring-orange-500 dark:bg-gray-700 dark:text-gray-100 dark:placeholder:text-gray-500"
                                    required
                                />
                            </div>
                        </div>

                        <!-- Password Field -->
                        <div class="space-y-2">
                            <label for="password" class="text-sm font-medium text-gray-700 dark:text-gray-200">
                                비밀번호
                            </label>
                            <div class="relative">
                                <svg class="absolute left-3 top-1/2 transform -translate-y-1/2 w-5 h-5 text-gray-400 dark:text-gray-500" xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                                    <rect width="18" height="11" x="3" y="11" rx="2" ry="2"/>
                                    <path d="M7 11V7a5 5 0 0 1 10 0v4"/>
                                </svg>
                                <input
                                    id="password"
                                    type="password"
                                    placeholder="최소 8자 이상"
                                    class="w-full pl-10 pr-12 py-3 border border-gray-300 dark:border-gray-600 rounded-lg focus:outline-none focus:border-orange-500 focus:ring-2 focus:ring-orange-500 dark:bg-gray-700 dark:text-gray-100 dark:placeholder:text-gray-500"
                                    required
                                />
                                <button
                                    type="button"
                                    onclick="togglePasswordVisibility('password', 'passwordEyeIcon')"
                                    class="absolute right-3 top-1/2 transform -translate-y-1/2 text-gray-400 hover:text-gray-600 dark:text-gray-500 dark:hover:text-gray-300"
                                >
                                    <svg id="passwordEyeIcon" xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                                        <path d="M2 12s3-7 10-7 10 7 10 7-3 7-10 7-10-7-10-7Z"/>
                                        <circle cx="12" cy="12" r="3"/>
                                    </svg>
                                </button>
                            </div>

                            <!-- Password Strength Indicator -->
                            <div id="passwordStrengthContainer" class="space-y-1 hidden">
                                <div class="h-2 rounded-full overflow-hidden bg-gray-200 dark:bg-gray-700">
                                    <div id="passwordStrengthBar" class="h-full strength-bar" style="width: 0%"></div>
                                </div>
                                <p id="passwordStrengthLabel" class="text-xs text-gray-600 dark:text-gray-400"></p>
                            </div>
                        </div>

                        <!-- Confirm Password Field -->
                        <div class="space-y-2">
                            <label for="confirmPassword" class="text-sm font-medium text-gray-700 dark:text-gray-200">
                                비밀번호 확인
                            </label>
                            <div class="relative">
                                <svg class="absolute left-3 top-1/2 transform -translate-y-1/2 w-5 h-5 text-gray-400 dark:text-gray-500" xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                                    <rect width="18" height="11" x="3" y="11" rx="2" ry="2"/>
                                    <path d="M7 11V7a5 5 0 0 1 10 0v4"/>
                                </svg>
                                <input
                                    id="confirmPassword"
                                    type="password"
                                    placeholder="비밀번호를 다시 입력하세요"
                                    class="w-full pl-10 pr-12 py-3 border border-gray-300 dark:border-gray-600 rounded-lg focus:outline-none focus:border-orange-500 focus:ring-2 focus:ring-orange-500 dark:bg-gray-700 dark:text-gray-100 dark:placeholder:text-gray-500"
                                    required
                                />
                                <button
                                    type="button"
                                    onclick="togglePasswordVisibility('confirmPassword', 'confirmPasswordEyeIcon')"
                                    class="absolute right-3 top-1/2 transform -translate-y-1/2 text-gray-400 hover:text-gray-600 dark:text-gray-500 dark:hover:text-gray-300"
                                >
                                    <svg id="confirmPasswordEyeIcon" xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                                        <path d="M2 12s3-7 10-7 10 7 10 7-3 7-10 7-10-7-10-7Z"/>
                                        <circle cx="12" cy="12" r="3"/>
                                    </svg>
                                </button>
                            </div>
                            <p id="passwordMatchMessage" class="text-xs hidden"></p>
                        </div>

                        <!-- Terms Agreement -->
                        <div class="space-y-3 pt-2">
                            <div class="flex items-start space-x-2">
                                <input
                                    type="checkbox"
                                    id="terms"
                                    class="custom-checkbox mt-0.5"
                                />
                                <label for="terms" class="text-sm cursor-pointer text-gray-700 dark:text-gray-300">
                                    <span class="text-orange-600 dark:text-orange-500">(필수)</span>
                                    <a href="#" class="text-orange-600 hover:text-orange-700 dark:text-orange-500 underline">이용약관</a>
                                    및
                                    <a href="#" class="text-orange-600 hover:text-orange-700 dark:text-orange-500 underline">개인정보처리방침</a>
                                    에 동의합니다
                                </label>
                            </div>

                            <div class="flex items-start space-x-2">
                                <input
                                    type="checkbox"
                                    id="marketing"
                                    class="custom-checkbox mt-0.5"
                                />
                                <label for="marketing" class="text-sm cursor-pointer text-gray-700 dark:text-gray-300">
                                    <span class="text-gray-500">(선택)</span>
                                    마케팅 정보 수신에 동의합니다
                                </label>
                            </div>
                        </div>

                        <!-- Sign Up Button -->
                        <button
                            id="submitBtn"
                            type="submit"
                            class="w-full bg-orange-600 hover:bg-orange-700 dark:bg-orange-600 dark:hover:bg-orange-700 text-white py-3 text-lg rounded-lg disabled:opacity-50 disabled:cursor-not-allowed transition-all flex items-center justify-center gap-2"
                        >
                            <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                                <path d="M16 21v-2a4 4 0 0 0-4-4H6a4 4 0 0 0-4 4v2"/>
                                <circle cx="9" cy="7" r="4"/>
                                <line x1="19" x2="19" y1="8" y2="14"/>
                                <line x1="22" x2="16" y1="11" y2="11"/>
                            </svg>
                            <span id="submitBtnText">회원가입</span>
                        </button>

                        <!-- Divider -->
                        <div class="relative my-6">
                            <div class="absolute inset-0 flex items-center">
                                <span class="w-full border-t border-gray-300 dark:border-gray-600"></span>
                            </div>
                            <div class="relative flex justify-center text-sm">
                                <span class="px-2 bg-white dark:bg-gray-800 text-gray-500 dark:text-gray-400">또는</span>
                            </div>
                        </div>

                        <!-- Social Sign Up Buttons -->
                        <div class="space-y-3">
                            <button
                                type="button"
                                class="w-full py-3 bg-white dark:bg-gray-700 border border-gray-300 dark:border-gray-600 text-gray-700 dark:text-gray-100 hover:bg-gray-50 dark:hover:bg-gray-600 rounded-lg transition-all flex items-center justify-center gap-2"
                            >
                                <svg class="w-5 h-5" viewBox="0 0 24 24">
                                    <path fill="currentColor" d="M22.56 12.25c0-.78-.07-1.53-.2-2.25H12v4.26h5.92c-.26 1.37-1.04 2.53-2.21 3.31v2.77h3.57c2.08-1.92 3.28-4.74 3.28-8.09z"/>
                                    <path fill="currentColor" d="M12 23c2.97 0 5.46-.98 7.28-2.66l-3.57-2.77c-.98.66-2.23 1.06-3.71 1.06-2.86 0-5.29-1.93-6.16-4.53H2.18v2.84C3.99 20.53 7.7 23 12 23z"/>
                                    <path fill="currentColor" d="M5.84 14.09c-.22-.66-.35-1.36-.35-2.09s.13-1.43.35-2.09V7.07H2.18C1.43 8.55 1 10.22 1 12s.43 3.45 1.18 4.93l2.85-2.22.81-.62z"/>
                                    <path fill="currentColor" d="M12 5.38c1.62 0 3.06.56 4.21 1.64l3.15-3.15C17.45 2.09 14.97 1 12 1 7.7 1 3.99 3.47 2.18 7.07l3.66 2.84c.87-2.6 3.3-4.53 6.16-4.53z"/>
                                </svg>
                                Google로 계속하기
                            </button>

                            <button
                                type="button"
                                class="w-full py-3 bg-white dark:bg-gray-700 border border-gray-300 dark:border-gray-600 text-gray-700 dark:text-gray-100 hover:bg-gray-50 dark:hover:bg-gray-600 rounded-lg transition-all flex items-center justify-center gap-2"
                            >
                                <svg class="w-5 h-5" fill="currentColor" viewBox="0 0 24 24">
                                    <path d="M12 0c-6.626 0-12 5.373-12 12 0 5.302 3.438 9.8 8.207 11.387.599.111.793-.261.793-.577v-2.234c-3.338.726-4.033-1.416-4.033-1.416-.546-1.387-1.333-1.756-1.333-1.756-1.089-.745.083-.729.083-.729 1.205.084 1.839 1.237 1.839 1.237 1.07 1.834 2.807 1.304 3.492.997.107-.775.418-1.305.762-1.604-2.665-.305-5.467-1.334-5.467-5.931 0-1.311.469-2.381 1.236-3.221-.124-.303-.535-1.524.117-3.176 0 0 1.008-.322 3.301 1.23.957-.266 1.983-.399 3.003-.404 1.02.005 2.047.138 3.006.404 2.291-1.552 3.297-1.23 3.297-1.23.653 1.653.242 2.874.118 3.176.77.84 1.235 1.911 1.235 3.221 0 4.609-2.807 5.624-5.479 5.921.43.372.823 1.102.823 2.222v3.293c0 .319.192.694.801.576 4.765-1.589 8.199-6.086 8.199-11.386 0-6.627-5.373-12-12-12z"/>
                                </svg>
                                GitHub로 계속하기
                            </button>
                        </div>
                    </div>
                </form>

                <!-- Footer -->
                <div class="w-full text-center pb-8 px-8">
                    <p class="text-sm text-gray-600 dark:text-gray-400">
                        이미 계정이 있으신가요?
                        <button
                            type="button"
                            onclick="switchToLogin()"
                            class="text-orange-600 hover:text-orange-700 dark:text-orange-500 dark:hover:text-orange-400 underline"
                        >
                            로그인
                        </button>
                    </p>
                </div>
            </div>
        </div>
    </div>

    <script>
        // Password visibility toggle
        function togglePasswordVisibility(inputId, iconId) {
            const input = document.getElementById(inputId);
            const icon = document.getElementById(iconId);
            
            if (input.type === 'password') {
                input.type = 'text';
                icon.innerHTML = `
                    <path d="M9.88 9.88a3 3 0 1 0 4.24 4.24"/>
                    <path d="M10.73 5.08A10.43 10.43 0 0 1 12 5c7 0 10 7 10 7a13.16 13.16 0 0 1-1.67 2.68"/>
                    <path d="M6.61 6.61A13.526 13.526 0 0 0 2 12s3 7 10 7a9.74 9.74 0 0 0 5.39-1.61"/>
                    <line x1="2" x2="22" y1="2" y2="22"/>
                `;
            } else {
                input.type = 'password';
                icon.innerHTML = `
                    <path d="M2 12s3-7 10-7 10 7 10 7-3 7-10 7-10-7-10-7Z"/>
                    <circle cx="12" cy="12" r="3"/>
                `;
            }
        }

        // Password strength checker
        function checkPasswordStrength(password) {
            if (!password) {
                return { strength: 0, label: '', color: '' };
            }

            let strength = 0;
            if (password.length >= 8) strength++;
            if (/[a-z]/.test(password) && /[A-Z]/.test(password)) strength++;
            if (/\d/.test(password)) strength++;
            if (/[!@#$%^&*(),.?":{}|<>]/.test(password)) strength++;

            if (strength <= 1) return { strength: 25, label: '약함', color: 'bg-red-500' };
            if (strength === 2) return { strength: 50, label: '보통', color: 'bg-yellow-500' };
            if (strength === 3) return { strength: 75, label: '강함', color: 'bg-orange-500' };
            return { strength: 100, label: '매우 강함', color: 'bg-green-500' };
        }

        // Update password strength indicator
        document.getElementById('password').addEventListener('input', function(e) {
            const password = e.target.value;
            const container = document.getElementById('passwordStrengthContainer');
            const bar = document.getElementById('passwordStrengthBar');
            const label = document.getElementById('passwordStrengthLabel');

            if (password) {
                const strength = checkPasswordStrength(password);
                container.classList.remove('hidden');
                bar.style.width = strength.strength + '%';
                bar.className = 'h-full strength-bar ' + strength.color;
                label.textContent = '비밀번호 강도: ' + strength.label;
            } else {
                container.classList.add('hidden');
            }
        });

        // Check password match
        function checkPasswordMatch() {
            const password = document.getElementById('password').value;
            const confirmPassword = document.getElementById('confirmPassword').value;
            const message = document.getElementById('passwordMatchMessage');

            if (confirmPassword) {
                message.classList.remove('hidden');
                if (password === confirmPassword) {
                    message.className = 'text-xs text-green-500 flex items-center gap-1';
                    message.innerHTML = `
                        <svg xmlns="http://www.w3.org/2000/svg" width="12" height="12" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                            <polyline points="20 6 9 17 4 12"/>
                        </svg>
                        비밀번호가 일치합니다
                    `;
                } else {
                    message.className = 'text-xs text-red-500';
                    message.textContent = '비밀번호가 일치하지 않습니다';
                }
            } else {
                message.classList.add('hidden');
            }
        }

        document.getElementById('confirmPassword').addEventListener('input', checkPasswordMatch);
        document.getElementById('password').addEventListener('input', checkPasswordMatch);

        // Form submission
        document.getElementById('signupForm').addEventListener('submit', function(e) {
            e.preventDefault();

            const name = document.getElementById('name').value;
            const email = document.getElementById('email').value;
            const password = document.getElementById('password').value;
            const confirmPassword = document.getElementById('confirmPassword').value;
            const agreeTerms = document.getElementById('terms').checked;

            // Validation
            if (!name || !email || !password || !confirmPassword) {
                alert('모든 필드를 입력해주세요.');
                return;
            }

            if (password !== confirmPassword) {
                alert('비밀번호가 일치하지 않습니다.');
                return;
            }

            if (password.length < 8) {
                alert('비밀번호는 최소 8자 이상이어야 합니다.');
                return;
            }

            if (!agreeTerms) {
                alert('이용약관에 동의해주세요.');
                return;
            }

            // Show loading state
            const submitBtn = document.getElementById('submitBtn');
            const submitBtnText = document.getElementById('submitBtnText');
            submitBtn.disabled = true;
            submitBtnText.innerHTML = `
                <svg class="spinner h-5 w-5" viewBox="0 0 24 24">
                    <circle class="opacity-25" cx="12" cy="12" r="10" stroke="currentColor" stroke-width="4" fill="none"/>
                    <path class="opacity-75" fill="currentColor" d="M4 12a8 8 0 018-8V0C5.373 0 0 5.373 0 12h4zm2 5.291A7.962 7.962 0 014 12H0c0 3.042 1.135 5.824 3 7.938l3-2.647z"/>
                </svg>
                회원가입 중...
            `;

            // Simulate API call
            setTimeout(() => {
                alert('회원가입이 완료되었습니다!');
                submitBtn.disabled = false;
                submitBtnText.innerHTML = '회원가입';
                // You can redirect or call a callback here
                // onSignUp();
            }, 1000);
        });

        // Navigation functions
        function backToLanding() {
            // Implement navigation to landing page
            alert('홈으로 이동');
        }

        function switchToLogin() {
            // Implement navigation to login page
            alert('로그인 페이지로 이동');
        }

        // Dark mode toggle (optional - add a button to toggle this)
        function toggleDarkMode() {
            document.documentElement.classList.toggle('dark');
        }
    </script>
</body>
</html>
