<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>


<style>
.card {
    background: white;
    border-radius: 0.5rem;
    border: 1px solid #e2e8f0;
    overflow: hidden;
}

.card-header {
    padding: 1.5rem;
    border-bottom: 1px solid #e2e8f0;
}

.card-title {
    font-size: 1.125rem;
    font-weight: 600;
    color: #0f172a;
}

.card-description {
    font-size: 0.875rem;
    color: #64748b;
    margin-top: 0.25rem;
}

.card-content {
    padding: 1.5rem;
}

.badge {
    display: inline-flex;
    align-items: center;
    padding: 0.25rem 0.625rem;
    font-size: 0.75rem;
    font-weight: 500;
    border-radius: 0.375rem;
    white-space: nowrap;
}

.badge-default {
    background-color: #ede9fe;
    color: #7c3aed;
}

.badge-secondary {
    background-color: #f1f5f9;
    color: #475569;
}

.badge-outline {
    background-color: transparent;
    border: 1px solid #cbd5e1;
    color: #475569;
}

.progress-bar {
    width: 100%;
    height: 0.5rem;
    background-color: #f1f5f9;
    border-radius: 9999px;
    overflow: hidden;
}

.progress-fill {
    height: 100%;
    background-color: #7c3aed;
    transition: width 0.3s ease;
}

.text-muted-foreground {
    color: #64748b;
}

.modal {
    display: none;
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.5);
    z-index: 50;
    align-items: center;
    justify-content: center;
}

.modal.show {
    display: flex;
}

.modal-content {
    background: white;
    border-radius: 0.5rem;
    padding: 1.5rem;
    max-width: 500px;
    width: 90%;
    max-height: 90vh;
    overflow-y: auto;
}

.modal-header {
    margin-bottom: 1rem;
}

.modal-title {
    font-size: 1.25rem;
    font-weight: 600;
    color: #0f172a;
}

.modal-description {
    font-size: 0.875rem;
    color: #64748b;
    margin-top: 0.25rem;
}

.btn {
    display: inline-flex;
    align-items: center;
    gap: 0.5rem;
    padding: 0.5rem 1rem;
    font-size: 0.875rem;
    font-weight: 500;
    border-radius: 0.375rem;
    cursor: pointer;
    transition: all 0.2s;
    border: none;
}

.btn-primary {
    background-color: #7c3aed;
    color: white;
}

.btn-primary:hover {
    background-color: #6d28d9;
}

.btn-outline {
    background-color: transparent;
    border: 1px solid #cbd5e1;
    color: #475569;
}

.btn-outline:hover {
    background-color: #f1f5f9;
}

.form-group {
    margin-bottom: 1rem;
}

.form-label {
    display: block;
    font-size: 0.875rem;
    font-weight: 500;
    color: #334155;
    margin-bottom: 0.5rem;
}

.form-input,
.form-select,
.form-textarea {
    width: 100%;
    padding: 0.5rem 0.75rem;
    font-size: 0.875rem;
    border: 1px solid #cbd5e1;
    border-radius: 0.375rem;
    transition: all 0.2s;
}

.form-input:focus,
.form-select:focus,
.form-textarea:focus {
    outline: none;
    border-color: #7c3aed;
    box-shadow: 0 0 0 3px rgba(124, 58, 237, 0.1);
}

.form-textarea {
    resize: vertical;
    min-height: 80px;
}

.table {
    width: 100%;
    border-collapse: collapse;
}

.table thead {
    border-bottom: 1px solid #e2e8f0;
}

.table th {
    padding: 0.75rem;
    text-align: left;
    font-size: 0.875rem;
    font-weight: 500;
    color: #64748b;
}

.table td {
    padding: 0.75rem;
    border-bottom: 1px solid #f1f5f9;
    font-size: 0.875rem;
}

.tab-list {
    display: flex;
    gap: 0.25rem;
    border-bottom: 1px solid #e2e8f0;
    margin-bottom: 1.5rem;
}

.tab {
    padding: 0.75rem 1rem;
    font-size: 0.875rem;
    font-weight: 500;
    color: #64748b;
    cursor: pointer;
    border-bottom: 2px solid transparent;
    transition: all 0.2s;
}

.tab:hover {
    color: #334155;
}

.tab.active {
    color: #7c3aed;
    border-bottom-color: #7c3aed;
}

.tab-content {
    display: none;
}

.tab-content.active {
    display: block;
}

</style>

<div class="space-y-6">
    <div class="flex justify-between items-center mb-6">
        <div>
            <h3 class="text-lg font-semibold">콘텐츠 제작 일정</h3>
            <p class="text-sm text-muted-foreground">
                플랫폼별 콘텐츠 일정을 관리하고 진행 상황을 추적하세요
            </p>
        </div>
        <button class="btn btn-primary" onclick="openModal('scheduleModal')">
            <i data-lucide="plus" class="w-4 h-4"></i>
            새 일정 추가
        </button>
    </div>

    <!-- 플랫폼별 통계 -->
    <div class="grid gap-4 md:grid-cols-3 mb-6">
        <div class="card">
            <div class="card-header flex flex-row items-center justify-between space-y-0 pb-2">
                <h3 class="text-sm font-medium">YouTube</h3>
                <i data-lucide="youtube" class="w-4 h-4 text-red-600"></i>
            </div>
            <div class="card-content">
                <div class="text-2xl font-bold">2건</div>
                <p class="text-xs text-muted-foreground">이번 주 예정</p>
            </div>
        </div>

        <div class="card">
            <div class="card-header flex flex-row items-center justify-between space-y-0 pb-2">
                <h3 class="text-sm font-medium">Instagram</h3>
                <i data-lucide="instagram" class="w-4 h-4 text-pink-600"></i>
            </div>
            <div class="card-content">
                <div class="text-2xl font-bold">2건</div>
                <p class="text-xs text-muted-foreground">이번 주 예정</p>
            </div>
        </div>

        <div class="card">
            <div class="card-header flex flex-row items-center justify-between space-y-0 pb-2">
                <h3 class="text-sm font-medium">TikTok</h3>
                <div class="w-4 h-4 bg-black rounded-sm"></div>
            </div>
            <div class="card-content">
                <div class="text-2xl font-bold">2건</div>
                <p class="text-xs text-muted-foreground">이번 주 예정</p>
            </div>
        </div>
    </div>

    <!-- 일정 테이블 -->
    <div class="card">
        <div class="card-header">
            <h3 class="card-title">예정된 콘텐츠</h3>
            <p class="card-description">다가오는 제작 및 업로드 일정</p>
        </div>
        <div class="card-content">
            <table class="table">
                <thead>
                    <tr>
                        <th>플랫폼</th>
                        <th>제목</th>
                        <th>일시</th>
                        <th>상태</th>
                        <th>썸네일</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>
                            <div class="flex items-center gap-2">
                                <i data-lucide="youtube" class="w-5 h-5 text-red-600"></i>
                                <span>YouTube</span>
                            </div>
                        </td>
                        <td>신제품 리뷰 - 갤럭시 S25</td>
                        <td>
                            <div class="text-sm">
                                <div>2025-10-28</div>
                                <div class="text-muted-foreground">18:00</div>
                            </div>
                        </td>
                        <td><span class="badge badge-default">편집중</span></td>
                        <td><span class="text-sm text-muted-foreground">준비완료</span></td>
                    </tr>
                    <tr>
                        <td>
                            <div class="flex items-center gap-2">
                                <i data-lucide="instagram" class="w-5 h-5 text-pink-600"></i>
                                <span>Instagram</span>
                            </div>
                        </td>
                        <td>일상 브이로그</td>
                        <td>
                            <div class="text-sm">
                                <div>2025-10-29</div>
                                <div class="text-muted-foreground">12:00</div>
                            </div>
                        </td>
                        <td><span class="badge badge-default">촬영완료</span></td>
                        <td><span class="text-sm text-muted-foreground">작업중</span></td>
                    </tr>
                    <tr>
                        <td>
                            <div class="flex items-center gap-2">
                                <div class="w-5 h-5 bg-black rounded-sm"></div>
                                <span>TikTok</span>
                            </div>
                        </td>
                        <td>댄스 챌린지</td>
                        <td>
                            <div class="text-sm">
                                <div>2025-10-30</div>
                                <div class="text-muted-foreground">20:00</div>
                            </div>
                        </td>
                        <td><span class="badge badge-secondary">기획</span></td>
                        <td><span class="text-sm text-muted-foreground">대기</span></td>
                    </tr>
                    <tr>
                        <td>
                            <div class="flex items-center gap-2">
                                <i data-lucide="youtube" class="w-5 h-5 text-red-600"></i>
                                <span>YouTube</span>
                            </div>
                        </td>
                        <td>Q&A 영상</td>
                        <td>
                            <div class="text-sm">
                                <div>2025-11-01</div>
                                <div class="text-muted-foreground">18:00</div>
                            </div>
                        </td>
                        <td><span class="badge badge-secondary">업로드완료</span></td>
                        <td><span class="text-sm text-muted-foreground">준비완료</span></td>
                    </tr>
                    <tr>
                        <td>
                            <div class="flex items-center gap-2">
                                <i data-lucide="instagram" class="w-5 h-5 text-pink-600"></i>
                                <span>Instagram</span>
                            </div>
                        </td>
                        <td>협찬 제품 소개</td>
                        <td>
                            <div class="text-sm">
                                <div>2025-11-02</div>
                                <div class="text-muted-foreground">15:00</div>
                            </div>
                        </td>
                        <td><span class="badge badge-outline">촬영중</span></td>
                        <td><span class="text-sm text-muted-foreground">대기</span></td>
                    </tr>
                    <tr>
                        <td>
                            <div class="flex items-center gap-2">
                                <div class="w-5 h-5 bg-black rounded-sm"></div>
                                <span>TikTok</span>
                            </div>
                        </td>
                        <td>메이크업 튜토리얼</td>
                        <td>
                            <div class="text-sm">
                                <div>2025-11-03</div>
                                <div class="text-muted-foreground">19:00</div>
                            </div>
                        </td>
                        <td><span class="badge badge-secondary">기획</span></td>
                        <td><span class="text-sm text-muted-foreground">대기</span></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>

<!-- Modal -->
<div id="scheduleModal" class="modal">
    <div class="modal-content">
        <div class="modal-header">
            <h3 class="modal-title">새 콘텐츠 일정 추가</h3>
            <p class="modal-description">새로운 콘텐츠 제작 일정을 등록하세요</p>
        </div>
        <form action="scheduleServlet" method="post">
            <div class="form-group">
                <label class="form-label" for="platform">플랫폼</label>
                <select class="form-select" id="platform" name="platform" required>
                    <option value="">플랫폼 선택</option>
                    <option value="youtube">YouTube</option>
                    <option value="instagram">Instagram</option>
                    <option value="tiktok">TikTok</option>
                </select>
            </div>
            <div class="form-group">
                <label class="form-label" for="title">콘텐츠 제목</label>
                <input class="form-input" id="title" name="title" type="text" placeholder="제목을 입력하세요" required>
            </div>
            <div class="grid grid-cols-2 gap-4">
                <div class="form-group">
                    <label class="form-label" for="date">업로드 날짜</label>
                    <input class="form-input" id="date" name="date" type="date" required>
                </div>
                <div class="form-group">
                    <label class="form-label" for="time">업로드 시간</label>
                    <input class="form-input" id="time" name="time" type="time" required>
                </div>
            </div>
            <div class="form-group">
                <label class="form-label" for="status">진행 상태</label>
                <select class="form-select" id="status" name="status" required>
                    <option value="">상태 선택</option>
                    <option value="planning">기획</option>
                    <option value="filming">촬영중</option>
                    <option value="filmed">촬영완료</option>
                    <option value="editing">편집중</option>
                    <option value="uploaded">업로드완료</option>
                </select>
            </div>
            <div class="form-group">
                <label class="form-label" for="description">설명</label>
                <textarea class="form-textarea" id="description" name="description" placeholder="콘텐츠 설명 및 메모"></textarea>
            </div>
            <div class="flex gap-2">
                <button type="submit" class="btn btn-primary flex-1">저장</button>
                <button type="button" class="btn btn-outline" onclick="closeModal('scheduleModal')">취소</button>
            </div>
        </form>
    </div>
</div>

<script>
    function openModal(modalId) {
        document.getElementById(modalId).classList.add('show');
    }

    function closeModal(modalId) {
        document.getElementById(modalId).classList.remove('show');
    }

    // Close modal when clicking outside
    document.getElementById('scheduleModal').addEventListener('click', function(e) {
        if (e.target === this) {
            closeModal('scheduleModal');
        }
    });

    lucide.createIcons();
</script>
