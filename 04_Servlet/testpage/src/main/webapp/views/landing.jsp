<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CREP - 1인 크리에이터를 위한 통합 ERP</title>
    <meta name="description" content="크리에이터의 성장을 가속화하는 통합 ERP. 콘텐츠 일정, 수익 관리, 협찬 계약을 한 곳에서 효율적으로 관리하세요.">
    
    <!-- Tailwind CSS -->
    <script src="https://cdn.tailwindcss.com"></script>
    
    <!-- Lucide Icons -->
    <script src="https://unpkg.com/lucide@latest"></script>
    
    <style>
        /* Custom styles for smooth transitions */
        * {
            transition-property: background-color, border-color, color;
            transition-duration: 200ms;
            transition-timing-function: ease-in-out;
        }
        
        .dark {
            color-scheme: dark;
        }
        
        /* Gradient animations */
        @keyframes gradient {
            0% { background-position: 0% 50%; }
            50% { background-position: 100% 50%; }
            100% { background-position: 0% 50%; }
        }
        
        .animate-gradient {
            background-size: 200% 200%;
            animation: gradient 15s ease infinite;
        }
        
        /* Smooth scroll */
        html {
            scroll-behavior: smooth;
        }
        
        /* Hide scrollbar for webkit browsers */
        ::-webkit-scrollbar {
            width: 10px;
        }
        
        ::-webkit-scrollbar-track {
            background: transparent;
        }
        
        ::-webkit-scrollbar-thumb {
            background: #ea580c;
            border-radius: 5px;
        }
        
        .dark ::-webkit-scrollbar-thumb {
            background: #fb923c;
        }
    </style>
    
    <script>
        // Tailwind configuration
        tailwind.config = {
            darkMode: 'class',
            theme: {
                extend: {
                    colors: {
                        orange: {
                            50: '#fff7ed',
                            100: '#ffedd5',
                            200: '#fed7aa',
                            300: '#fdba74',
                            400: '#fb923c',
                            500: '#f97316',
                            600: '#ea580c',
                            700: '#c2410c',
                            800: '#9a3412',
                            900: '#7c2d12',
                            950: '#431407',
                        }
                    }
                }
            }
        }
    </script>
</head>
<body class="bg-white dark:bg-gray-900 text-gray-900 dark:text-gray-100">
    <!-- Top Navigation Bar -->
    <nav class="border-b bg-white dark:bg-gray-900 border-gray-200 dark:border-gray-800 sticky top-0 z-50 shadow-sm">
        <div class="flex items-center justify-between gap-4 px-6 py-3">
            <!-- Left Section - Logo -->
            <div class="flex items-center gap-3">
                <div class="w-12 h-12 bg-gradient-to-br from-orange-400 to-orange-600 rounded-lg flex items-center justify-center">
                    <span class="text-white text-2xl font-bold">C</span>
                </div>
                <h1 class="text-3xl font-bold text-orange-600 dark:text-orange-500">CREP</h1>
            </div>

            <!-- Right Section - Actions -->
            <div class="flex items-center gap-3">
                <!-- Dark Mode Toggle -->
                <button
                    id="darkModeToggle"
                    class="p-2 rounded-lg transition-colors text-gray-600 dark:text-gray-300 hover:text-orange-600 dark:hover:text-orange-500 hover:bg-orange-50 dark:hover:bg-gray-800"
                    title="다크 모드 전환"
                >
                    <i data-lucide="moon" class="w-5 h-5 dark:hidden"></i>
                    <i data-lucide="sun" class="w-5 h-5 hidden dark:block"></i>
                </button>

                <!-- Auth Buttons -->
                <div class="flex items-center gap-2">
                    <button
                        class="flex items-center gap-2 px-4 py-2 rounded-lg transition-colors text-gray-700 dark:text-gray-300 hover:text-orange-600 dark:hover:text-orange-500 hover:bg-orange-50 dark:hover:bg-gray-800"
                        onclick="alert('로그인 기능은 실제 애플리케이션에서 사용 가능합니다.')"
                    >
                        <i data-lucide="log-in" class="w-4 h-4"></i>
                        <span>로그인</span>
                    </button>
                    <button
                        class="flex items-center gap-2 px-4 py-2 rounded-lg bg-orange-600 hover:bg-orange-700 text-white transition-colors"
                        onclick="alert('회원가입 기능은 실제 애플리케이션에서 사용 가능합니다.')"
                    >
                        <i data-lucide="user-plus" class="w-4 h-4"></i>
                        <span>회원가입</span>
                    </button>
                </div>
            </div>
        </div>
    </nav>

    <!-- Main Content -->
    <main>
        <!-- Hero Section -->
        <section class="relative overflow-hidden bg-gradient-to-br from-orange-50 via-white to-orange-100 dark:from-gray-900 dark:via-gray-800 dark:to-orange-950">
            <div class="max-w-7xl mx-auto px-6 py-20 lg:py-32">
                <div class="grid lg:grid-cols-2 gap-12 items-center">
                    <!-- Left Content -->
                    <div class="space-y-8">
                        <div class="inline-flex items-center gap-2 px-4 py-2 rounded-full bg-orange-100 dark:bg-orange-900/30 text-orange-700 dark:text-orange-400">
                            <i data-lucide="star" class="w-4 h-4 fill-current"></i>
                            <span class="text-sm">1인 크리에이터를 위한 올인원 솔루션</span>
                        </div>
                        
                        <div class="space-y-4">
                            <h1 class="text-5xl lg:text-6xl font-bold leading-tight text-gray-900 dark:text-white">
                                크리에이터의<br>
                                <span class="text-orange-600 dark:text-orange-500">성장을 가속화</span>하는<br>
                                통합 ERP
                            </h1>
                            <p class="text-xl text-gray-600 dark:text-gray-300">
                                CREP으로 콘텐츠 일정, 수익 관리, 협찬 계약을 한 곳에서 효율적으로 관리하세요.
                            </p>
                        </div>

                        <div class="flex flex-col sm:flex-row gap-4">
                           <a
    href="http://localhost:8001/page/pages/dashboard.jsp"
    class="flex items-center justify-center gap-2 px-8 py-4 text-lg rounded-lg bg-orange-600 hover:bg-orange-700 text-white transition-colors"
>
    <span>무료로 시작하기</span>
    <i data-lucide="arrow-right" class="w-5 h-5"></i>
</a>
                            <button
                                class="flex items-center justify-center gap-2 px-8 py-4 text-lg rounded-lg border-2 border-gray-300 dark:border-gray-600 hover:bg-gray-50 dark:hover:bg-gray-800 transition-colors"
                                onclick="alert('데모 영상은 준비 중입니다.')"
                            >
                                <i data-lucide="play-circle" class="w-5 h-5"></i>
                                <span>데모 보기</span>
                            </button>
                        </div>

                        <div class="flex items-center gap-8 pt-4">
                            <div class="flex -space-x-3">
                                <div class="w-10 h-10 rounded-full border-2 border-white dark:border-gray-900 bg-gradient-to-br from-orange-400 to-orange-600 flex items-center justify-center text-white text-xs font-bold">1K</div>
                                <div class="w-10 h-10 rounded-full border-2 border-white dark:border-gray-900 bg-gradient-to-br from-orange-400 to-orange-600 flex items-center justify-center text-white text-xs font-bold">2K</div>
                                <div class="w-10 h-10 rounded-full border-2 border-white dark:border-gray-900 bg-gradient-to-br from-orange-400 to-orange-600 flex items-center justify-center text-white text-xs font-bold">3K</div>
                                <div class="w-10 h-10 rounded-full border-2 border-white dark:border-gray-900 bg-gradient-to-br from-orange-400 to-orange-600 flex items-center justify-center text-white text-xs font-bold">4K</div>
                            </div>
                            <div>
                                <div class="flex gap-1">
                                    <i data-lucide="star" class="w-5 h-5 fill-orange-500 text-orange-500"></i>
                                    <i data-lucide="star" class="w-5 h-5 fill-orange-500 text-orange-500"></i>
                                    <i data-lucide="star" class="w-5 h-5 fill-orange-500 text-orange-500"></i>
                                    <i data-lucide="star" class="w-5 h-5 fill-orange-500 text-orange-500"></i>
                                    <i data-lucide="star" class="w-5 h-5 fill-orange-500 text-orange-500"></i>
                                </div>
                                <p class="text-sm mt-1 text-gray-600 dark:text-gray-400">
                                    10,000+ 크리에이터가 사용 중
                                </p>
                            </div>
                        </div>
                    </div>

                    <!-- Right Image -->
                    <div class="relative">
                        <div class="absolute inset-0 bg-gradient-to-tr from-orange-500/20 to-orange-600/20 rounded-3xl blur-3xl"></div>
                        <div class="relative rounded-2xl overflow-hidden shadow-2xl border-4 border-orange-500/20">
                            <img
                                src="https://images.unsplash.com/photo-1617899644490-fbead7fb6183?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3w3Nzg4Nzd8MHwxfHNlYXJjaHwxfHxjb250ZW50JTIwY3JlYXRvciUyMHdvcmtzcGFjZXxlbnwxfHx8fDE3NjE2MDI4NDF8MA&ixlib=rb-4.1.0&q=80&w=1080"
                                alt="CREP Dashboard Preview"
                                class="w-full h-auto"
                            >
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!-- Stats Section -->
        <section class="py-12 border-y bg-gray-50 dark:bg-gray-800 border-gray-200 dark:border-gray-700">
            <div class="max-w-7xl mx-auto px-6">
                <div class="grid grid-cols-2 lg:grid-cols-4 gap-8">
                    <div class="text-center">
                        <div class="text-4xl font-bold text-orange-600 dark:text-orange-500 mb-2">10,000+</div>
                        <div class="text-gray-600 dark:text-gray-400">크리에이터</div>
                    </div>
                    <div class="text-center">
                        <div class="text-4xl font-bold text-orange-600 dark:text-orange-500 mb-2">₩50억+</div>
                        <div class="text-gray-600 dark:text-gray-400">관리 수익</div>
                    </div>
                    <div class="text-center">
                        <div class="text-4xl font-bold text-orange-600 dark:text-orange-500 mb-2">98%</div>
                        <div class="text-gray-600 dark:text-gray-400">만족도</div>
                    </div>
                    <div class="text-center">
                        <div class="text-4xl font-bold text-orange-600 dark:text-orange-500 mb-2">24/7</div>
                        <div class="text-gray-600 dark:text-gray-400">지원</div>
                    </div>
                </div>
            </div>
        </section>

        <!-- Features Section -->
        <section class="py-20 bg-white dark:bg-gray-900">
            <div class="max-w-7xl mx-auto px-6">
                <div class="text-center mb-16">
                    <h2 class="text-4xl font-bold mb-4 text-gray-900 dark:text-white">
                        모든 기능을 한곳에서
                    </h2>
                    <p class="text-xl text-gray-600 dark:text-gray-400">
                        크리에이터에게 필요한 모든 도구를 제공합니다
                    </p>
                </div>

                <div class="grid md:grid-cols-2 lg:grid-cols-3 gap-8">
                    <!-- Feature 1 -->
                    <div class="p-6 rounded-xl border-2 border-gray-200 dark:border-gray-700 bg-white dark:bg-gray-800 hover:border-orange-500 dark:hover:border-orange-600 hover:shadow-lg hover:scale-105 transition-all">
                        <div class="w-12 h-12 rounded-lg flex items-center justify-center mb-4 bg-orange-100 dark:bg-orange-900/30">
                            <i data-lucide="layout-dashboard" class="w-6 h-6 text-orange-600 dark:text-orange-500"></i>
                        </div>
                        <h3 class="text-xl font-bold mb-2 text-gray-900 dark:text-white">통합 대시보드</h3>
                        <p class="text-gray-600 dark:text-gray-400">
                            모든 플랫폼의 데이터를 한눈에 확인하고 성과를 실시간으로 모니터링하세요.
                        </p>
                    </div>

                    <!-- Feature 2 -->
                    <div class="p-6 rounded-xl border-2 border-gray-200 dark:border-gray-700 bg-white dark:bg-gray-800 hover:border-orange-500 dark:hover:border-orange-600 hover:shadow-lg hover:scale-105 transition-all">
                        <div class="w-12 h-12 rounded-lg flex items-center justify-center mb-4 bg-orange-100 dark:bg-orange-900/30">
                            <i data-lucide="calendar" class="w-6 h-6 text-orange-600 dark:text-orange-500"></i>
                        </div>
                        <h3 class="text-xl font-bold mb-2 text-gray-900 dark:text-white">스마트 일정 관리</h3>
                        <p class="text-gray-600 dark:text-gray-400">
                            콘텐츠 제작 일정을 효율적으로 관리하고 여러 플랫폼의 업로드 일정을 동기화하세요.
                        </p>
                    </div>

                    <!-- Feature 3 -->
                    <div class="p-6 rounded-xl border-2 border-gray-200 dark:border-gray-700 bg-white dark:bg-gray-800 hover:border-orange-500 dark:hover:border-orange-600 hover:shadow-lg hover:scale-105 transition-all">
                        <div class="w-12 h-12 rounded-lg flex items-center justify-center mb-4 bg-orange-100 dark:bg-orange-900/30">
                            <i data-lucide="video" class="w-6 h-6 text-orange-600 dark:text-orange-500"></i>
                        </div>
                        <h3 class="text-xl font-bold mb-2 text-gray-900 dark:text-white">콘텐츠 관리</h3>
                        <p class="text-gray-600 dark:text-gray-400">
                            리뷰, 브이로그, 튜토리얼, 소통, 엔터테인먼트 등 5가지 카테고리로 체계적으로 관리하세요.
                        </p>
                    </div>

                    <!-- Feature 4 -->
                    <div class="p-6 rounded-xl border-2 border-gray-200 dark:border-gray-700 bg-white dark:bg-gray-800 hover:border-orange-500 dark:hover:border-orange-600 hover:shadow-lg hover:scale-105 transition-all">
                        <div class="w-12 h-12 rounded-lg flex items-center justify-center mb-4 bg-orange-100 dark:bg-orange-900/30">
                            <i data-lucide="wallet" class="w-6 h-6 text-orange-600 dark:text-orange-500"></i>
                        </div>
                        <h3 class="text-xl font-bold mb-2 text-gray-900 dark:text-white">재무 관리</h3>
                        <p class="text-gray-600 dark:text-gray-400">
                            광고, 협찬, 후원, 굿즈 판매 등 다양한 수익원을 자동으로 집계하고 시각화하세요.
                        </p>
                    </div>

                    <!-- Feature 5 -->
                    <div class="p-6 rounded-xl border-2 border-gray-200 dark:border-gray-700 bg-white dark:bg-gray-800 hover:border-orange-500 dark:hover:border-orange-600 hover:shadow-lg hover:scale-105 transition-all">
                        <div class="w-12 h-12 rounded-lg flex items-center justify-center mb-4 bg-orange-100 dark:bg-orange-900/30">
                            <i data-lucide="handshake" class="w-6 h-6 text-orange-600 dark:text-orange-500"></i>
                        </div>
                        <h3 class="text-xl font-bold mb-2 text-gray-900 dark:text-white">협찬 계약</h3>
                        <p class="text-gray-600 dark:text-gray-400">
                            협찬 제안부터 계약, 정산까지 모든 과정을 체계적으로 관리하세요.
                        </p>
                    </div>

                    <!-- Feature 6 -->
                    <div class="p-6 rounded-xl border-2 border-gray-200 dark:border-gray-700 bg-white dark:bg-gray-800 hover:border-orange-500 dark:hover:border-orange-600 hover:shadow-lg hover:scale-105 transition-all">
                        <div class="w-12 h-12 rounded-lg flex items-center justify-center mb-4 bg-orange-100 dark:bg-orange-900/30">
                            <i data-lucide="trending-up" class="w-6 h-6 text-orange-600 dark:text-orange-500"></i>
                        </div>
                        <h3 class="text-xl font-bold mb-2 text-gray-900 dark:text-white">성장 분석</h3>
                        <p class="text-gray-600 dark:text-gray-400">
                            데이터 기반 인사이트로 채널 성장을 가속화하세요.
                        </p>
                    </div>
                </div>
            </div>
        </section>

        <!-- Benefits Section -->
        <section class="py-20 bg-orange-50 dark:bg-gray-800">
            <div class="max-w-7xl mx-auto px-6">
                <div class="grid lg:grid-cols-2 gap-12 items-center">
                    <!-- Left Image -->
                    <div class="order-2 lg:order-1">
                        <div class="rounded-2xl overflow-hidden shadow-2xl">
                            <img
                                src="https://images.unsplash.com/photo-1689004624325-6edf074228dd?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3w3Nzg4Nzd8MHwxfHNlYXJjaHwxfHxzb2NpYWwlMjBtZWRpYSUyMGFuYWx5dGljcyUyMGRhc2hib2FyZHxlbnwxfHx8fDE3NjE1MDgxODZ8MA&ixlib=rb-4.1.0&q=80&w=1080"
                                alt="Analytics Dashboard"
                                class="w-full h-auto"
                            >
                        </div>
                    </div>

                    <!-- Right Content -->
                    <div class="space-y-8 order-1 lg:order-2">
                        <div>
                            <h2 class="text-4xl font-bold mb-4 text-gray-900 dark:text-white">
                                크리에이터에게<br>필요한 모든 것
                            </h2>
                            <p class="text-xl text-gray-600 dark:text-gray-400">
                                CREP은 크리에이터의 성공을 위해 설계되었습니다
                            </p>
                        </div>

                        <div class="space-y-6">
                            <!-- Benefit 1 -->
                            <div class="flex gap-4">
                                <div class="flex-shrink-0 w-12 h-12 rounded-lg flex items-center justify-center bg-orange-100 dark:bg-orange-900/30">
                                    <i data-lucide="clock" class="w-6 h-6 text-orange-600 dark:text-orange-500"></i>
                                </div>
                                <div>
                                    <h3 class="font-bold mb-1 text-gray-900 dark:text-white">시간 절약</h3>
                                    <p class="text-gray-600 dark:text-gray-400">
                                        반복적인 관리 업무를 자동화하여 콘텐츠 제작에 집중하세요.
                                    </p>
                                </div>
                            </div>

                            <!-- Benefit 2 -->
                            <div class="flex gap-4">
                                <div class="flex-shrink-0 w-12 h-12 rounded-lg flex items-center justify-center bg-orange-100 dark:bg-orange-900/30">
                                    <i data-lucide="bar-chart-3" class="w-6 h-6 text-orange-600 dark:text-orange-500"></i>
                                </div>
                                <div>
                                    <h3 class="font-bold mb-1 text-gray-900 dark:text-white">수익 최적화</h3>
                                    <p class="text-gray-600 dark:text-gray-400">
                                        다양한 수익원을 분석하여 수익 구조를 최적화하세요.
                                    </p>
                                </div>
                            </div>

                            <!-- Benefit 3 -->
                            <div class="flex gap-4">
                                <div class="flex-shrink-0 w-12 h-12 rounded-lg flex items-center justify-center bg-orange-100 dark:bg-orange-900/30">
                                    <i data-lucide="users" class="w-6 h-6 text-orange-600 dark:text-orange-500"></i>
                                </div>
                                <div>
                                    <h3 class="font-bold mb-1 text-gray-900 dark:text-white">협업 편의성</h3>
                                    <p class="text-gray-600 dark:text-gray-400">
                                        팀원 및 협력사와 효율적으로 협업하세요.
                                    </p>
                                </div>
                            </div>

                            <!-- Benefit 4 -->
                            <div class="flex gap-4">
                                <div class="flex-shrink-0 w-12 h-12 rounded-lg flex items-center justify-center bg-orange-100 dark:bg-orange-900/30">
                                    <i data-lucide="zap" class="w-6 h-6 text-orange-600 dark:text-orange-500"></i>
                                </div>
                                <div>
                                    <h3 class="font-bold mb-1 text-gray-900 dark:text-white">빠른 의사결정</h3>
                                    <p class="text-gray-600 dark:text-gray-400">
                                        실시간 데이터로 신속하고 정확한 의사결정을 하세요.
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!-- Categories Section -->
        <section class="py-20 bg-white dark:bg-gray-900">
            <div class="max-w-7xl mx-auto px-6">
                <div class="text-center mb-16">
                    <h2 class="text-4xl font-bold mb-4 text-gray-900 dark:text-white">
                        5가지 콘텐츠 카테고리
                    </h2>
                    <p class="text-xl text-gray-600 dark:text-gray-400">
                        체계적인 콘텐츠 분류로 효율적인 관리
                    </p>
                </div>

                <div class="grid grid-cols-2 md:grid-cols-5 gap-6">
                    <div class="p-6 rounded-xl border-2 border-gray-200 dark:border-gray-700 bg-white dark:bg-gray-800 text-center hover:border-orange-500 dark:hover:border-orange-600 hover:shadow-lg hover:scale-105 transition-all">
                        <h3 class="text-xl font-bold text-gray-900 dark:text-white text-center">리뷰</h3>
                    </div>
                    <div class="p-6 rounded-xl border-2 border-gray-200 dark:border-gray-700 bg-white dark:bg-gray-800 text-center hover:border-orange-500 dark:hover:border-orange-600 hover:shadow-lg hover:scale-105 transition-all">
                        <h3 class="text-xl font-bold text-gray-900 dark:text-white text-center">브이로그</h3>
                    </div>
                    <div class="p-6 rounded-xl border-2 border-gray-200 dark:border-gray-700 bg-white dark:bg-gray-800 text-center hover:border-orange-500 dark:hover:border-orange-600 hover:shadow-lg hover:scale-105 transition-all">
                        <h3 class="text-xl font-bold text-gray-900 dark:text-white text-center">튜토리얼</h3>
                    </div>
                    <div class="p-6 rounded-xl border-2 border-gray-200 dark:border-gray-700 bg-white dark:bg-gray-800 text-center hover:border-orange-500 dark:hover:border-orange-600 hover:shadow-lg hover:scale-105 transition-all">
                        <h3 class="text-xl font-bold text-gray-900 dark:text-white text-center">소통</h3>
                    </div>
                    <div class="p-6 rounded-xl border-2 border-gray-200 dark:border-gray-700 bg-white dark:bg-gray-800 text-center hover:border-orange-500 dark:hover:border-orange-600 hover:shadow-lg hover:scale-105 transition-all">
                        <h3 class="text-xl font-bold text-gray-900 dark:text-white">엔터테인먼트</h3>
                    </div>
                </div>
            </div>
        </section>

        <!-- Testimonials Section -->
        <section class="py-20 bg-gray-50 dark:bg-gray-800">
            <div class="max-w-7xl mx-auto px-6">
                <div class="text-center mb-16">
                    <h2 class="text-4xl font-bold mb-4 text-gray-900 dark:text-white">
                        크리에이터들의 이야기
                    </h2>
                </div>

                <div class="grid md:grid-cols-3 gap-8">
                    <!-- Testimonial 1 -->
                    <div class="p-6 rounded-xl border-2 border-gray-200 dark:border-gray-700 bg-white dark:bg-gray-900">
                        <div class="flex gap-1 mb-4">
                            <i data-lucide="star" class="w-5 h-5 fill-orange-500 text-orange-500"></i>
                            <i data-lucide="star" class="w-5 h-5 fill-orange-500 text-orange-500"></i>
                            <i data-lucide="star" class="w-5 h-5 fill-orange-500 text-orange-500"></i>
                            <i data-lucide="star" class="w-5 h-5 fill-orange-500 text-orange-500"></i>
                            <i data-lucide="star" class="w-5 h-5 fill-orange-500 text-orange-500"></i>
                        </div>
                        <p class="text-base text-gray-600 dark:text-gray-300 mb-6">
                            "CREP 덕분에 콘텐츠 제작에만 집중할 수 있게 되었습니다. 일정 관리와 수익 분석이 정말 편리해요!"
                        </p>
                        <div class="flex items-center gap-3">
                            <div class="w-12 h-12 rounded-full bg-gradient-to-br from-orange-400 to-orange-600 flex items-center justify-center text-white font-bold">
                                김
                            </div>
                            <div>
                                <div class="font-bold text-gray-900 dark:text-white">김유튜버</div>
                                <div class="text-sm text-gray-600 dark:text-gray-400">테크 리뷰어</div>
                            </div>
                        </div>
                    </div>

                    <!-- Testimonial 2 -->
                    <div class="p-6 rounded-xl border-2 border-gray-200 dark:border-gray-700 bg-white dark:bg-gray-900">
                        <div class="flex gap-1 mb-4">
                            <i data-lucide="star" class="w-5 h-5 fill-orange-500 text-orange-500"></i>
                            <i data-lucide="star" class="w-5 h-5 fill-orange-500 text-orange-500"></i>
                            <i data-lucide="star" class="w-5 h-5 fill-orange-500 text-orange-500"></i>
                            <i data-lucide="star" class="w-5 h-5 fill-orange-500 text-orange-500"></i>
                            <i data-lucide="star" class="w-5 h-5 fill-orange-500 text-orange-500"></i>
                        </div>
                        <p class="text-base text-gray-600 dark:text-gray-300 mb-6">
                            "여러 플랫폼의 협찬 계약을 한 곳에서 관리할 수 있어서 너무 좋아요. 시간이 정말 많이 절약됩니다."
                        </p>
                        <div class="flex items-center gap-3">
                            <div class="w-12 h-12 rounded-full bg-gradient-to-br from-orange-400 to-orange-600 flex items-center justify-center text-white font-bold">
                                박
                            </div>
                            <div>
                                <div class="font-bold text-gray-900 dark:text-white">박크리에이터</div>
                                <div class="text-sm text-gray-600 dark:text-gray-400">뷰티 인플루언서</div>
                            </div>
                        </div>
                    </div>

                    <!-- Testimonial 3 -->
                    <div class="p-6 rounded-xl border-2 border-gray-200 dark:border-gray-700 bg-white dark:bg-gray-900">
                        <div class="flex gap-1 mb-4">
                            <i data-lucide="star" class="w-5 h-5 fill-orange-500 text-orange-500"></i>
                            <i data-lucide="star" class="w-5 h-5 fill-orange-500 text-orange-500"></i>
                            <i data-lucide="star" class="w-5 h-5 fill-orange-500 text-orange-500"></i>
                            <i data-lucide="star" class="w-5 h-5 fill-orange-500 text-orange-500"></i>
                            <i data-lucide="star" class="w-5 h-5 fill-orange-500 text-orange-500"></i>
                        </div>
                        <p class="text-base text-gray-600 dark:text-gray-300 mb-6">
                            "수익원이 다양해질수록 관리가 복잡했는데, CREP으로 모든 걸 한눈에 볼 수 있게 되었습니다."
                        </p>
                        <div class="flex items-center gap-3">
                            <div class="w-12 h-12 rounded-full bg-gradient-to-br from-orange-400 to-orange-600 flex items-center justify-center text-white font-bold">
                                이
                            </div>
                            <div>
                                <div class="font-bold text-gray-900 dark:text-white">이스트리머</div>
                                <div class="text-sm text-gray-600 dark:text-gray-400">게임 스트리머</div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!-- CTA Section -->
        <section class="py-20 bg-gradient-to-r from-orange-500 to-orange-600 dark:from-orange-900 dark:to-orange-800">
            <div class="max-w-4xl mx-auto px-6 text-center">
                <h2 class="text-4xl font-bold text-white mb-4">
                    지금 바로 시작하세요
                </h2>
                <p class="text-xl text-orange-100 mb-8">
                    무료로 CREP을 시작하고 크리에이터로서의 성장을 경험하세요
                </p>
                <div class="flex flex-col sm:flex-row gap-4 justify-center">
                    <button
                        class="flex items-center justify-center gap-2 px-8 py-4 text-lg rounded-lg bg-white text-orange-600 hover:bg-orange-50 transition-colors"
                        onclick="alert('무료 체험은 실제 애플리케이션에서 시작하실 수 있습니다.')"
                    >
                        <span>무료로 시작하기</span>
                        <i data-lucide="arrow-right" class="w-5 h-5"></i>
                    </button>
                    <button
                        class="flex items-center justify-center gap-2 px-8 py-4 text-lg rounded-lg border-2 border-white text-white hover:bg-white/10 transition-colors"
                        onclick="alert('로그인 기능은 실제 애플리케이션에서 사용 가능합니다.')"
                    >
                        <span>로그인</span>
                    </button>
                </div>
                <div class="mt-8 flex flex-wrap items-center justify-center gap-6">
                    <div class="flex items-center gap-2 text-orange-100">
                        <i data-lucide="check" class="w-5 h-5"></i>
                        <span>신용카드 불필요</span>
                    </div>
                    <div class="flex items-center gap-2 text-orange-100">
                        <i data-lucide="check" class="w-5 h-5"></i>
                        <span>언제든지 취소 가능</span>
                    </div>
                    <div class="flex items-center gap-2 text-orange-100">
                        <i data-lucide="shield" class="w-5 h-5"></i>
                        <span>안전한 데이터 관리</span>
                    </div>
                </div>
            </div>
        </section>

        <!-- Footer -->
        <footer class="py-12 border-t bg-white dark:bg-gray-900 border-gray-200 dark:border-gray-800">
            <div class="max-w-7xl mx-auto px-6">
                <div class="grid md:grid-cols-4 gap-8 mb-8">
                    <div>
                        <h3 class="font-bold mb-4 text-gray-900 dark:text-white">CREP</h3>
                        <p class="text-sm text-gray-600 dark:text-gray-400">
                            1인 크리에이터를 위한<br>통합 ERP 시스템
                        </p>
                    </div>
                    <div>
                        <h4 class="font-bold mb-4 text-gray-900 dark:text-white">제품</h4>
                        <ul class="space-y-2 text-sm text-gray-600 dark:text-gray-400">
                            <li><a href="#" class="hover:text-orange-600">기능</a></li>
                            <li><a href="#" class="hover:text-orange-600">요금제</a></li>
                            <li><a href="#" class="hover:text-orange-600">데모</a></li>
                        </ul>
                    </div>
                    <div>
                        <h4 class="font-bold mb-4 text-gray-900 dark:text-white">지원</h4>
                        <ul class="space-y-2 text-sm text-gray-600 dark:text-gray-400">
                            <li><a href="#" class="hover:text-orange-600">고객센터</a></li>
                            <li><a href="#" class="hover:text-orange-600">가이드</a></li>
                            <li><a href="#" class="hover:text-orange-600">FAQ</a></li>
                        </ul>
                    </div>
                    <div>
                        <h4 class="font-bold mb-4 text-gray-900 dark:text-white">회사</h4>
                        <ul class="space-y-2 text-sm text-gray-600 dark:text-gray-400">
                            <li><a href="#" class="hover:text-orange-600">소개</a></li>
                            <li><a href="#" class="hover:text-orange-600">블로그</a></li>
                            <li><a href="#" class="hover:text-orange-600">채용</a></li>
                        </ul>
                    </div>
                </div>
                <div class="pt-8 border-t text-center text-sm border-gray-200 dark:border-gray-800 text-gray-600 dark:text-gray-500">
                    © 2025 CREP. All rights reserved.
                </div>
            </div>
        </footer>
    </main>

    <script>
        // Initialize Lucide icons
        lucide.createIcons();

        // Dark mode toggle functionality
        const darkModeToggle = document.getElementById('darkModeToggle');
        const htmlElement = document.documentElement;

        // Check for saved dark mode preference
        const darkMode = localStorage.getItem('darkMode');
        if (darkMode === 'enabled') {
            htmlElement.classList.add('dark');
        }

        darkModeToggle.addEventListener('click', () => {
            htmlElement.classList.toggle('dark');
            
            // Save preference
            if (htmlElement.classList.contains('dark')) {
                localStorage.setItem('darkMode', 'enabled');
            } else {
                localStorage.setItem('darkMode', 'disabled');
            }
            
            // Reinitialize icons after DOM change
            lucide.createIcons();
        });

        // Smooth scroll for anchor links
        document.querySelectorAll('a[href^="#"]').forEach(anchor => {
            anchor.addEventListener('click', function (e) {
                e.preventDefault();
                const target = document.querySelector(this.getAttribute('href'));
                if (target) {
                    target.scrollIntoView({
                        behavior: 'smooth',
                        block: 'start'
                    });
                }
            });
        });

        // Add scroll animation to elements
        const observerOptions = {
            threshold: 0.1,
            rootMargin: '0px 0px -100px 0px'
        };

        const observer = new IntersectionObserver((entries) => {
            entries.forEach(entry => {
                if (entry.isIntersecting) {
                    entry.target.style.opacity = '1';
                    entry.target.style.transform = 'translateY(0)';
                }
            });
        }, observerOptions);

        // Observe sections for scroll animations
        document.querySelectorAll('section').forEach(section => {
            section.style.opacity = '0';
            section.style.transform = 'translateY(20px)';
            section.style.transition = 'opacity 0.6s ease-out, transform 0.6s ease-out';
            observer.observe(section);
        });
    </script>
</body>
</html>
